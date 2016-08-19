<%@page contentType="text/html; charset=utf-8"%>
<%-- <%
	
if(session.getAttribute("name")==null){
	response.sendRedirect("login.jsp");
}
String name=(String)session.getAttribute("name");
%> --%>
<html>
<head>
<title>天丽书籍流通信息管理系统</title>
<meta charset="UTF-8" />
 <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
 <link rel="stylesheet" type="text/css" href="easyui/css/admin.css" /> 
</head>
<body class="easyui-layout">

<div data-options="region:'north',title:'header',split:true,noheader:true"  style="background: rgb(78, 190, 214) none repeat scroll 0% 0%; height: 60px; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
	 <!-- <div class="logo" style="">
	 	<table>
	 		<tr>
	 			<td width="1200"><font size="5">天丽图书流通信息管理系统</font></td>
	 			<td class="logout">您好，admin<a href="login.jsp">注销</a></td>
	 		</tr>
	 	</table>	 	 		  		 	
	 </div>  -->	 
	 <div class="logo">天丽图书流通信息管理系统</div>
	<div class="logout">您好，admin<a href="newlogin.jsp">注销</a></div>  
</div>   
<div data-options="region:'south',title:'footer',split:true,noheader:true" style="height:35px;line-height:30px;text-align:center;"> 
	&copy;2016 Telek. Powered by&nbsp; YYJ. 
</div>    
<div data-options="region:'west',title:'导航',split:true,iconCls:'icon-world'" style="width:180px;padding:10px;">
	<ul id="nav">
		
	</ul>
</div>   
<div data-options="region:'center'" >
<!-- style="overflow:hidden;" -->
	<div id="tabs" class="easyui-tabs">
		<div title="起始页" iconCls="icon-house" style="padding:0 10px;display:block;background:url('easyui/themes/gray/images/telek2.png') no-repeat 200px 200px;"> 
			欢迎来到天丽图书流通信息管理系统！ 
		</div> 
		
		<!-- <div title="test">
		</div> -->
	</div>
	
</div> 
<!-- background:url('easyui/themes/gray/images/telek.png'); background:#B3DFDA-->
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js" ></script>
<script type="text/javascript" src="js/admin.js"></script>
</body>
</html>