

$(function() {
	
	$('#bookinfomanager').datagrid({
		
		url : 'bookinfo/showPage',
		
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
		toolbar : '#bookinfomanager_tool',
		columns : [ [ {
			field : 'id',
			title : '自动编号',
			width : 150,
			checkbox : true,
		}, {
			field : 'code',
			title : '编码',
			width : 150,
		},{
			field : 'author',
			title : '作者',
			width : 150,
		}, {
			field : 'title',
			title : '题目',
			width : 150,
		}]],
		
	});
	
	
	//debugger;
	$('#bookinfomanager_add')
			.dialog(
					{
						
						width : 350,
						title : '新增管理',
						modal : true,
						closed : true,
						iconCls : 'icon-bookinfo-add',
						buttons : [
								{
									text : '提交',
									iconCls : 'icon-save',
									handler : function() {
										$.ajax({
											url : 'bookinfo/add',
											type : 'post',
											
											data : {
												
												code : $('input[name="code_add"]').val(),
														
												author : $('input[name="author_add"]').val(),
												
														
												title : $('input[name="title_add"]').val(),
																																									
											
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
													$('#bookinfomanager_add').dialog(
															'close').form(
															'reset');
													$('#bookinfomanager').datagrid(
															'reload');
													//$('#bookinfomanager').datagrid('loadData',dataSource);
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
										$('#bookinfomanager_add').dialog('close').form(
												'reset');
									},
								} ],
					});

	$('#bookinfomanager_edit').dialog(
			{
				width : 350,
				title : '修改管理',
				modal : true,
				closed : true,
				iconCls : 'icon-bookinfo-add',
				buttons : [
						{
							text : '提交',
							iconCls : 'icon-save',
							handler : function() {
								// alert($('input[name="uid"]').val()+"|"+$('input[name="bookinfomanager_edit"]').val()+"|"+$('#auth_edit').combotree('getText'));
								if ($('#bookinfomanager_edit').form('validate')) {
									$.ajax({
										url : 'bookinfo/update',
										type : 'post',
										data : {
											id : $('input[name="uid"]').val(),
											code : $('input[name="code_edit"]')
													.val(),
											author : $('input[name="author_edit"]')
													.val(),
										 	title : $('input[name="title_edit"]')
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
												$('#bookinfomanager_edit').dialog(
														'close').form('reset');
												$('#bookinfomanager')
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
								$('#bookinfomanager_edit').dialog('close')
										.form('reset');
							},
						} ],
			});


	bookinfomanager_tool = {

		redo : function() {
			$('#bookinfomanager').datagrid('unselectAll');
		},

		reload : function() {
			$('#bookinfomanager').datagrid('reload');
			
		},
		add : function() {
			$('#bookinfomanager_add').dialog('open');
			$('input[name="bookinfomanager"]').focus();
		},

		remove : function() {
			var rows = $('#bookinfomanager').datagrid('getSelections');
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
							url : 'bookinfo/deleteIds',
							data : {
								ids : ids.join(','),
							},
							beforeSend : function() {
								$('#bookinfomanager').datagrid('loading');
							},
							success : function(data) {
								if (data) {
									$('#bookinfomanager').datagrid('loaded');
									$('#bookinfomanager').datagrid('load');
									$('#bookinfomanager').datagrid('unselectAll');
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
			var rows = $('#bookinfomanager').datagrid('getSelections');
			if (rows.length > 1) {
				$.messager.alert('警告操作！', '编辑记录只能选定一条数据！', 'warning');
			} else if (rows.length == 1) {
				// alert("rows[0].id--->"+rows[0].id);
				$
						.ajax({
							url : 'bookinfo/get',
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
									$('#bookinfomanager_edit').form('load', {
										uid : obj.id, 
										code_edit : obj.code,
										author_edit : obj.author,
										title_edit : obj.title,
										
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
			
			$('#bookinfomanager').datagrid({
				
				url : 'bookinfo/showSearch' ,
				queryParams : {
					author : $('input[name="author"]').val(),
					title : $('input[name="title"]').val(),
					
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
				toolbar : '#bookinfomanager_tool',
				columns : [ [ {
					field : 'id',
					title : '自动编号',
					width : 200,
					checkbox : true,
				}, {
					field : 'author',
					title : '作者',
					width : 200,
				}, {
					field : 'title',
					title : '题目',
					width : 200,
				}] ],
			});
		},
	};
});