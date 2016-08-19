<%@page contentType="text/html; charset=utf-8" %>
<html>
	<title>权限分配管理</title>

	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="css/admin.css" />
	
	<script type="text/javascript" src="js/authoritymanager.js"></script>
	
	<table id="authoritymanager"></table>
	<div id="authoritymanager_tool" style="padding:5px;">
		<div style="margin-bottom:5px;">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="authoritymanager_tool.add();">添加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="authoritymanager_tool.edit();">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="authoritymanager_tool.remove();">删除</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="authoritymanager_tool.reload();">刷新</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="authoritymanager_tool.redo();">取消选择</a>		
		</div>
		<div style="padding:0 0 0 7px;color:#333;">
			查询： 用户名<input type="text" class="textbox" name="adminname" style="width:110px"> &nbsp;&nbsp; 
				权限等级<select id="functions_search" class="easyui-combobox" name="functions_search" style="width:200px;">   
					    <option>1</option>   
					    <option>2</option>   
					</select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="authoritymanager_tool.search();">查询</a>
		</div>
	</div>
	
	<form id="authoritymanager_add" style="margin:0;padding:5px 0 0 25px;color:#333;">
		<table>
			<tr>
				<td style="text-align:right">用户名：</td>
				<td><input type="text" name="adminname_add" class="textbox" style="width:200px;"></td>
			</tr>
			<tr>
				<td style="text-align:right">权限等级：</td>
				<td><select id="functions_add" class="easyui-combobox" name="functions_add" style="width:200px;">   
					    <option>1</option>   
					    <option>2</option>   
					</select>
				</td>
			</tr>
		</table>	
	</form>
	
	<form id="authoritymanager_edit" style="margin:0;padding:5px 0 0 25px;color:#333;">
		<input type="hidden" name="uid" class="textbox" style="width:200px;">
		<table>
			<tr>
				<td style="text-align:right">用户名：</td>
				<td><input type="text" name="adminname_edit" class="textbox" style="width:200px;"></td>
			</tr>
			<tr>
				<td style="text-align:right">权限等级：</td>
				<td><select id="functions_edit" class="easyui-combobox" name="functions_edit" style="width:200px;">   
					    <option>1</option>   
					    <option>2</option>   
					</select>
				</td>
			</tr>
		</table>	
	</form>

</html>
