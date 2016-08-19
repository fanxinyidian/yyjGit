$(function() {
	
	$('#manageradmin').datagrid({
		
		url : 'admin/showPage',

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
		toolbar : '#manager_tool',
		columns : [ [ {
			field : 'id',
			title : '自动编号',
			width : 200,
			checkbox : true,
		}, {
			field : 'name',
			title : '用户名',
			width : 200,
		}, {
			field : 'password',
			title : '密码',
			width : 200,
		},

		] ],
	});

	$('#manager_add')
			.dialog(
					{
						width : 350,
						title : '新增管理',
						modal : true,
						closed : true,
						iconCls : 'icon-admin-add',
						buttons : [
								{
									text : '提交',
									iconCls : 'icon-save',
									handler : function() {
										$.ajax({
											url : 'admin/add',
											type : 'post',
											data : {
												name : $('input[name="name_add"]')
														.val(),
												password : $('input[name="password_add"]')
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
													$('#manager_add').dialog(
															'close').form(
															'reset');
													$('#manageradmin').datagrid(
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
										$('#manager_add').dialog('close').form(
												'reset');
									},
								} ],
					});

	$('#manager_edit').dialog(
			{
				width : 350,
				title : '修改管理',
				modal : true,
				closed : true,
				iconCls : 'icon-admin-add',
				buttons : [
						{
							text : '提交',
							iconCls : 'icon-save',
							handler : function() {
								
								if ($('#manager_edit').form('validate')) {
									$.ajax({
										url : 'admin/update',
										type : 'post',
										data : {
											id : $('input[name="uid"]').val(),
											name : $('input[name="name_edit"]')
													.val(),
											password : $('input[name="password_edit"]')
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
												$('#manager_edit').dialog(
														'close').form('reset');
												$('#manageradmin')
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
								$('#manager_edit').dialog('close')
										.form('reset');
							},
						} ],
			});

	

	manager_tool = {

		redo : function() {
			$('#manageradmin').datagrid('unselectAll');
		},

		reload : function() {
			$('#manageradmin').datagrid('reload');
		},
		add : function() {
			$('#manager_add').dialog('open');
			$('input[name="manageradmin"]').focus();
		},

		remove : function() {
			var rows = $('#manageradmin').datagrid('getSelections');
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
							url : 'admin/deleteIds',
							data : {
								ids : ids.join(','),
							},
							beforeSend : function() {
								$('#manageradmin').datagrid('loading');
							},
							success : function(data) {
								if (data) {
									$('#manageradmin').datagrid('loaded');
									$('#manageradmin').datagrid('load');
									$('#manageradmin').datagrid('unselectAll');
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
			var rows = $('#manageradmin').datagrid('getSelections');
			if (rows.length > 1) {
				$.messager.alert('警告操作！', '编辑记录只能选定一条数据！', 'warning');
			} else if (rows.length == 1) {
				$
						.ajax({
							url : 'admin/get',
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

									$('#manager_edit').form('load', {
										uid : obj.id, 
										name_edit : obj.name,
										password_edit : obj.password,
										
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
			
			$('#manageradmin').datagrid({
				url : 'admin/showSearch',
				queryParams : {
					name : $('input[name="name"]').val(),
					
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
				toolbar : '#manager_tool',
				columns : [ [ {
					field : 'id',
					title : '自动编号',
					width : 200,
					checkbox : true,
				}, {
					field : 'name',
					title : '用户名',
					width : 200,
				}, {
					field : 'password',
					title : '密码',
					width : 200,
				},] ],
			});
		},
	};
});