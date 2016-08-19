$(function() {
	$('#statu').combobox({
		value : ""
	});
	
	$('#circulatestatemanager').datagrid({
		
		url : 'circulatestate/showPage',
		
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
		toolbar : '#circulatestatemanager_tool',
		columns : [ [ {
			field : 'id',
			title : '自动编号',
			width : 150,
			checkbox : true,
		},{
			field : 'code',
			title : '编码',
			width : 150,
		},{
			field : 'borrowName',
			title : '借阅人',
			width : 150,
		},{
			field : 'startTime',
			title : '开始时间',
			width : 150,
		},{
			field : 'endTime',
			title : '结束时间',
			width : 150,
		},{
			field : 'statu',
			title : '状态',
			width : 150,
		}

		] ],
		
	});
	
	

	$('#circulatestatemanager_add')
			.dialog(
					{
						width : 350,
						title : '新增管理',
						modal : true,
						closed : true,
						iconCls : 'icon-circulate-add',
						buttons : [
								{
									text : '提交',
									iconCls : 'icon-save',
									handler : function() {
										$.ajax({
											url : 'circulatestate/add',
											type : 'post',
											data : {
												borrowName : $('input[name="borrowName_add"]')
												.val(),
												code : $('input[name="code_add"]')
														.val(),
												startTime : $('input[name="startTime_add"]').val(),
														
												endTime : $('input[name="endTime_add"]').val(),
														
												statu : $('select[name="cs_add"]')
														.val(),
												//statu : $('#cs').
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
													$('#circulatestatemanager_add').dialog(
															'close').form(
															'reset');
													$('#circulatestatemanager').datagrid(
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
										$('#circulatestatemanager_add').dialog('close').form(
												'reset');
									},
								} ],
					});

	$('#circulatestatemanager_edit').dialog(
			{
				width : 350,
				title : '修改管理',
				modal : true,
				closed : true,
				iconCls : 'icon-circulate-edit',
				buttons : [
						{
							text : '提交',
							iconCls : 'icon-save',
							handler : function() {
								
								if ($('#circulatestatemanager_edit').form('validate')) {
									$.ajax({
										url : 'circulatestate/update',
										type : 'post',
										data : {
											id : $('input[name="uid"]').val(),
											
											borrowName : $('input[name="borrowName_edit"]')
											.val(),
											code : $('input[name="code_edit"]')
													.val(),
											startTime : $('input[name="startTime_edit"]').val(),
													
											endTime : $('input[name="endTime_edit"]').val(),
													
											statu : $('select[name="cs_edit"]')
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
														bottom:''
													}
												});
												$('#circulatestatemanager_edit').dialog(
														'close').form('reset');
												$('#circulatestatemanager')
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
								$('#circulatestatemanager_edit').dialog('close')
										.form('reset');
							},
						} ],
			});

	

	circulatestatemanager_tool = {

		redo : function() {
			$('#circulatestatemanager').datagrid('unselectAll');
		},

		reload : function() {
			$('#circulatestatemanager').datagrid('reload');
			//$('#circulatestatemanager').datagrid('loadData',dataSource);
		},
		add : function() {
			$('#circulatestatemanager_add').dialog('open');
			$('input[name="circulatestatemanager"]').focus();
		},

		remove : function() {
			var rows = $('#circulatestatemanager').datagrid('getSelections');
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
							url : 'circulatestate/deleteIds',
							data : {
								ids : ids.join(','),
							},
							beforeSend : function() {
								$('#circulatestatemanager').datagrid('loading');
							},
							success : function(data) {
								if (data) {
									$('#circulatestatemanager').datagrid('loaded');
									$('#circulatestatemanager').datagrid('load');
									$('#circulatestatemanager').datagrid('unselectAll');
									$.messager.show({
										title : '提示',
										msg : data + '个管理被删除成功！',
										style:{
											right:'',
											center:'',														
											bottom:''
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
			var rows = $('#circulatestatemanager').datagrid('getSelections');
			if (rows.length > 1) {
				$.messager.alert('警告操作！', '编辑记录只能选定一条数据！', 'warning');
			} else if (rows.length == 1) {
				
				$
						.ajax({
							url : 'circulatestate/get',
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

									$('#circulatestatemanager_edit').form('load', {
										uid : obj.id, 
										borrowName_edit : obj.borrowName,
										code_edit : obj.code,
										
										startTime_edit : obj.startTime,
										endTime_edit : obj.endTime,
										cs_edit: obj.statu
										
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
			$('#circulatestatemanager').datagrid({
				
				url : 'circulatestate/showSearch' ,
				queryParams : {
					code : $('input[name="code"]').val(),
					borrowName : $('input[name="borrowName"]').val(),
					startTime : $('input[name="startTime"]').val(),
					endTime : $('input[name="endTime"]').val(),
					statu : $('input[name="statu"]').val()
					
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
				toolbar : '#circulatestatemanager_tool',
				columns : [ [ {
					field : 'id',
					title : '自动编号',
					width : 200,
					checkbox : true,
				}, {
					field : 'code',
					title : '编号',
					width : 200,
				}, {
					field : 'borrowName',
					title : '借阅人',
					width : 200,
				},{
					field : 'startTime',
					title : '开始时间',
					width : 200,
				},{
					field : 'endTime',
					title : '结束时间',
					width : 200,
				},{
					field : 'statu',
					title : '状态',
					width : 200,
				}] ],
			});
		},
	};
});