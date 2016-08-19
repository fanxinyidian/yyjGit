$(function() {
	$('#functions_search').combobox({
		value : ""
	});
	
	$('#authoritymanager').datagrid({
		
		url : 'adminfunction/showPage',

		fit : true,
		fitColumns : false,
		striped : true,
		rownumbers : true,
		border : false,
		pagination : true,
		pageSize : 20,
		pageList : [ 10, 20, 30, 40, 50 ],
		pageNumber : 1,
		sortName : 'date',
		sortOrder : 'desc',
		toolbar : '#authoritymanager_tool',
		columns : [ [ {
			field : 'id',
			title : '自动编号',
			width : 200,
			checkbox : true,
		}, {
			field : 'adminname',
			title : '用户名',
			width : 200,
		}, {
			field : 'functions',
			title : '权限等级',
			width : 200,
		},

		] ],
	});

	$('#authoritymanager_add')
			.dialog(
					{
						width : 350,
						title : '新增管理',
						modal : true,
						closed : true,
						iconCls : 'icon-save',
						buttons : [
								{
									text : '提交',
									iconCls : 'icon-add-new',
									handler : function() {
										$.ajax({
											url : 'adminfunction/add',
											type : 'post',
											data : {
												adminname : $('input[name="adminname_add"]')
														.val(),
												functions : $('select[name="functions_add"]')
														.val(),
												
											},
											beforeSend : function() {
												$.messager.progress({
													text : '正在新增中...',
												});
											},
											success : function(data, response,
													status) {
												$.messager.progress('close');
												

												if (data > 0) {
													$.messager.show({
														title : '提示',
														msg : '新增管理成功',
														style:{
															right:'',
															center:'',														
															bottom:'',
														}
													});
													$('#authoritymanager_add').dialog(
															'close').form(
															'reset');
													$('#authoritymanager').datagrid(
															'reload');
												} else {
													$.messager.alert('新增失败！',
															'未知错误导致失败，请重试！',
															'warning');
												}
											}
										});
									},
								},
								{
									text : '取消',
									iconCls : 'icon-redo',
									handler : function() {
										$('#authoritymanager_add').dialog('close').form(
												'reset');
									},
								} ],
					});

	$('#authoritymanager_edit').dialog(
			{
				width : 350,
				title : '修改管理',
				modal : true,
				closed : true,
				iconCls : 'icon-adminfunction-add',
				buttons : [
						{
							text : '提交',
							iconCls : 'icon-save',
							handler : function() {
								
								if ($('#authoritymanager_edit').form('validate')) {
									$.ajax({
										url : 'adminfunction/update',
										type : 'post',
										data : {
											id : $('input[name="uid"]').val(),
											adminname : $('input[name="adminname_edit"]')
													.val(),
											functions : $('select[name="functions_edit"]')
													.val(),
											
										},
										beforeSend : function() {
											$.messager.progress({
												text : '正在修改中...',
											});
										},
										success : function(data, response,
												status) {
											$.messager.progress('close');

											if (data > 0) {
												$.messager.show({
													title : '提示',
													msg : '修改管理成功',
													style:{
														right:'',
														center:'',														
														bottom:'',
													}
												});
												$('#authoritymanager_edit').dialog(
														'close').form('reset');
												$('#authoritymanager')
														.datagrid('reload');
											} else {
												$.messager.alert('修改失败！',
														'未知错误导致失败，请重试！',
														'warning');
											}
										}
									});
								}
							},
						},
						{
							text : '取消',
							iconCls : 'icon-redo',
							handler : function() {
								$('#authoritymanager_edit').dialog('close')
										.form('reset');
							},
						} ],
			});

	

	authoritymanager_tool = {

		redo : function() {
			$('#authoritymanager').datagrid('unselectAll');
		},

		reload : function() {
			$('#authoritymanager').datagrid('reload');
		},
		add : function() {
			$('#authoritymanager_add').dialog('open');
			$('input[name="authoritymanager"]').focus();
		},

		remove : function() {
			var rows = $('#authoritymanager').datagrid('getSelections');
			if (rows.length > 0) {
				$.messager.confirm('确定操作', '您正在要删除所选的记录吗？', function(flag) {
					if (flag) {
						var ids = [];
						for (var i = 0; i < rows.length; i++) {
							ids.push(rows[i].id);
						}
						console.log(ids.join(','));
						$.ajax({
							type : 'POST',
							url : 'adminfunction/deleteIds',
							data : {
								ids : ids.join(','),
							},
							beforeSend : function() {
								$('#authoritymanager').datagrid('loading');
							},
							success : function(data) {
								if (data) {
									$('#authoritymanager').datagrid('loaded');
									$('#authoritymanager').datagrid('load');
									$('#authoritymanager').datagrid('unselectAll');
									$.messager.show({
										title : '提示',
										msg : data + '个管理被删除成功！',
										style:{
											right:'',
											center:'',														
											bottom:'',
										}
									});
								}
							},
						});
					}
				});
			} else {
				$.messager.alert('提示', '请选择要删除的记录！', 'info');
			}
		},

		edit : function() {
			var rows = $('#authoritymanager').datagrid('getSelections');
			if (rows.length > 1) {
				$.messager.alert('警告操作！', '编辑记录只能选定一条数据！', 'warning');
			} else if (rows.length == 1) {
				$
						.ajax({
							url : 'adminfunction/get',
							type : 'post',
							data : {
								id : rows[0].id,
							},
							beforeSend : function() {
								$.messager.progress({
									text : '正在获取中...',
								});
							},
							success : function(data, response, status) {
								$.messager.progress('close');
								
								if (data) {
									
									var obj = $.parseJSON(data);

									$('#authoritymanager_edit').form('load', {
										uid : obj.id, 
										adminname_edit : obj.adminname,
										functions_edit : obj.functions,
										
									}).dialog('open');

									

								} else {
									$.messager.alert('获取失败！', '未知错误导致失败，请重试！',
											'warning');
								}
							}
						});
			} else if (rows.length == 0) {
				$.messager.alert('警告操作！', '编辑记录至少选定一条数据！', 'warning');
			}
		},

		search : function() {
			
			$('#authoritymanager').datagrid({
				url : 'adminfunction/showSearch',
				queryParams : {
					adminname : $('input[name="adminname"]').val(),
					functions : $('input[name="functions_search"]').val(),
				},
				fit : true,
				fitColumns : false,
				striped : true,
				rownumbers : true,
				border : false,
				pagination : true,
				pageSize : 10,
				pageList : [ 10, 20, 30, 40, 50 ],
				pageNumber : 1,
				sortName : 'date',
				sortOrder : 'desc',
				toolbar : '#authoritymanager_tool',
				columns : [ [ {
					field : 'id',
					title : '自动编号',
					width : 200,
					checkbox : true,
				}, {
					field : 'adminname',
					title : '用户名',
					width : 200,
				}, {
					field : 'functions',
					title : '权限等级',
					width : 200,
				},] ],
			});
		},
	};
});