<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>天丽图书流通信息管理系统</title>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<!-- <link rel="stylesheet" type="text/css" href="css/login.css" />  -->

<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/engine.js"> </script>
<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/util.js"> </script>
<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/interface/dwrLogin.js"> </script>
</head>

<body>
 <div id="login" class="easyui-dialog" title="欢迎登陆" style="width:300px;height:180px;"   
        data-options="iconCls:'icon-login',resizable:false,buttons:'#btn',modal:true">   
     <p style="padding:2px 15px"> <font color="#400080">管理员帐号</font>：<input type="text" id="name" name="name_edit" class="textbox"></p>
	<p style="padding:2px 15px"><font color="#400080">管理员密码</font>：<input type="password" id="password" name="password_edit" class="textbox"></p>
    
</div> 
<div id="btn">
	 <a href="#" class="easyui-linkbutton"><font color="#8000ff">登录</font></a> 
</div> 

<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js" ></script>

<script type="text/javascript" src="js/dwrlogin.js"></script>

</body>
</html>