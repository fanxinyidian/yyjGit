 <%@page contentType="text/html; charset=utf-8" %>
<html>
	<title>流通状态管理</title>
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
	
	<script type="text/javascript" src="js/circulatestatemanager.js"></script> 
 	<table id="circulatestatemanager" width="500" border="1"></table>
	<div id="circulatestatemanager_tool" style="padding:5px;">
		 <div style="margin-bottom:5px;">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="circulatestatemanager_tool.add();">添加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="circulatestatemanager_tool.edit();">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="circulatestatemanager_tool.remove();">删除</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="circulatestatemanager_tool.reload();">刷新</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="circulatestatemanager_tool.redo();">取消选择</a>		
		</div>
		<div style="padding:0 0 0 7px;color:#333;">
			查询：借阅人<input type="text" class="textbox" name="borrowName" style="width:110px">   
				编号<input type="text" class="textbox" name="code" style="width:110px">
				开始时间<input type="text" name="startTime" class="easyui-datebox" editable="false" style="width:110px">
				结束时间<input type="text" name="endTime" class="easyui-datebox" editable="false" style="width:110px">
				状态<select id="statu" class="easyui-combobox" name="statu" style="width:200px;">   
					    <option>已归还</option>   
					    <option>待归还</option>   
					</select>
				<!-- 状态<input id="statu" class="easyui-combobox" name="statu" data-options="valueField:'id',textField:'text',url:'statu。json'" /> -->  
			
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="circulatestatemanager_tool.search();">查询</a>
		</div>
	</div>

	<form id="circulatestatemanager_add" style="margin:0;padding:5px 0 0 25px;color:#333;">
		<table>
			<tr>
				<td style="text-align:right">借阅人：</td>
				<td><input type="text" name="borrowName_add" class="textbox" style="width:200px;"></td>
			</tr>
			<tr>
				<td style="text-align:right">编号：</td>
				<td><input type="text" name="code_add" class="textbox" style="width:200px;"></td>
			</tr>
			<tr>
				<td style="text-align:right">开始时间：</td>
				<td><input type="text" name="startTime_add" class="easyui-datebox" editable="false" style="width:200px;"></td>
			</tr>
			<tr>
				<td style="text-align:right">结束时间：</td>
				<td><input type="text" name="endTime_add" class="easyui-datebox" editable="false" style="width:200px;"></td>
			</tr>
			<tr>
				<td style="text-align:right">状态：</td>
				<td>
					<select id="cs_add" class="easyui-combobox" name="cs_add" style="width:200px;">      
					    <option>待归还</option>   
					    <option>已归还</option>     
					</select> 
				</td>
			</tr>
		</table>
	</form>
	
	<form id="circulatestatemanager_edit" style="margin:0;padding:5px 0 0 25px;color:#333;">
		<input type="hidden" name="uid" class="textbox" style="width:200px;">
		<table>
			<tr>
				<td style="text-align:right">借阅人：</td>
				<td><input type="text" name="borrowName_edit" class="textbox" style="width:200px;"></td>
			</tr>
			<tr>
				<td style="text-align:right">编号：</td>
				<td><input type="text" name="code_edit" class="textbox" style="width:200px;"></td>
			</tr>
			<tr>
				<td style="text-align:right">开始时间：</td>
				<td><input type="text" name="startTime_edit" class="easyui-datebox" editable="false" style="width:200px;"></td>
			</tr>
			<tr>
				<td style="text-align:right">结束时间：</td>
				<td><input type="text" name="endTime_edit" class="easyui-datebox" editable="false" style="width:200px;"></td>
			</tr>
			<tr>
				<td style="text-align:right">状态：</td>
				<td><select id="cs_edit" class="easyui-combobox" name="cs_edit" style="width:200px;">      
					    <option>待归还</option>   
					    <option>已归还</option>     
					</select>
				</td>
			</tr>
		</table>
	</form> 

</html>