<%@page contentType="text/html; charset=utf-8"%>
<html> 
	<title>图书信息管理</title>
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="easyui/css/admin.css" />
	
	<script type="text/javascript" src="js/bookinfomanager.js"></script>

	<table id="bookinfomanager" width="500" border="1"></table>
	<div id="bookinfomanager_tool" style="padding:5px;">
		<div style="margin-bottom:5px;">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="bookinfomanager_tool.add();">添加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="bookinfomanager_tool.edit();">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="bookinfomanager_tool.remove();">删除</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="bookinfomanager_tool.reload();">刷新</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="bookinfomanager_tool.redo();">取消选择</a>		
		</div>
		<div style="padding:0 0 0 7px;color:#333;">
			查询：作者<input type="text" class="textbox" name="author" style="width:110px">  &nbsp;&nbsp;   题目<input type="text" class="textbox" name="title" style="width:110px"> &nbsp;&nbsp;  
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="bookinfomanager_tool.search();">查询</a>
		</div>
	</div>
	
	<form id="bookinfomanager_add" style="margin:0;padding:5px 0 0 25px;color:#333;">
		<table>
			<tr>
				<td>编码：</td>
				<td><input type="text" name="code_add" class="textbox" style="width:200px;"></td>
			</tr>
			<tr>
				<td style="text-align:right">作者：</td>
				<td><input type="text" name="author_add" class="textbox" style="width:200px;"></td>
			</tr>
			<tr>
				<td style="text-align:right">题目：</td>
				<td><input type="text" name="title_add" class="textbox" style="width:200px;"></td>
			</tr>
		</table>  
	</form>
	
	<form id="bookinfomanager_edit" style="margin:0;padding:5px 0 0 25px;color:#333;">
		<input type="hidden" name="uid" class="textbox" style="width:200px;">
		<table>
			<tr>
				<td>编码：</td>
				<td><input type="text" name="code_edit" class="textbox" style="width:200px;"></td>
			</tr>
			<tr>
				<td style="text-align:right">作者：</td>
				<td><input type="text" name="author_edit" class="textbox" style="width:200px;"></td>
			</tr>
			<tr>
				<td style="text-align:right">题目：</td>
				<td><input type="text" name="title_edit" class="textbox" style="width:200px;"></td>
			</tr>
		</table>  
	</form>
	
</html>

