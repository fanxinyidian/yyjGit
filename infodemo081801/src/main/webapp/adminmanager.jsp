<%@page contentType="text/html; charset=utf-8" %>
<html>
	<title>用户信息管理</title>

	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="css/admin.css" />
	
	<script type="text/javascript" src="js/adminmanager.js"></script>
	
	<table id="manageradmin"></table>
	<div id="manager_tool" style="padding:5px;">
		<div style="margin-bottom:5px;">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="manager_tool.add();">添加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="manager_tool.edit();">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="manager_tool.remove();">删除</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="manager_tool.reload();">刷新</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="manager_tool.redo();">取消选择</a>		
		</div>
		<div style="padding:0 0 0 7px;color:#333;">
			查询： 用户名<input type="text" class="textbox" name="name" style="width:110px"> &nbsp;&nbsp; 
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="manager_tool.search();">查询</a>
		</div>
	</div>
	
	<form id="manager_add" style="margin:0;padding:5px 0 0 25px;color:#333;">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="name_add" class="textbox" style="width:200px;"></td>
			</tr>
			<tr>
				<td style="text-align:right">密码：</td>
				<td><input type="text" name="password_add" class="textbox" style="width:200px;"></td>
			</tr>
		</table>	
	</form>
	
	<form id="manager_edit" style="margin:0;padding:5px 0 0 25px;color:#333;">
		<input type="hidden" name="uid" class="textbox" style="width:200px;">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="name_edit" class="textbox" style="width:200px;"></td>
			</tr>
			<tr>
				<td style="text-align:right">密码：</td>
				<td><input type="text" name="password_edit" class="textbox" style="width:200px;"></td>
			</tr>
		</table>	
	</form>

</html>
