 <%@ page language="java" contentType="text/html; charset=utf-8"%>  
<%  
 String path = request.getContextPath();  
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
 %> 
 <!DOCTYPE HTML>  
 <html>  
 <head>  
    <base href="<%=basePath%>">  
    <title>电子资源管理</title>  
    <script type="text/javascript" src="<%=request.getContextPath()%>/dwr/engine.js"> </script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/util.js"> </script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/interface/dwrFile.js"> </script>
  
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="easyui/css/admin.css" />
	
    <link href="<%=request.getContextPath()%>/easyui/css/uploadify.css" rel="stylesheet" type="text/css" />  
	<script src="<%=request.getContextPath()%>/easyui/jquery-1.9.1.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/easyui/jquery.uploadify.js" type="text/javascript"></script>
      
     
	<script type="text/javascript" src="js/textsourcemanager.js"></script>
   
</head> 

<body class="easyui-layout">  
	<div data-options="region:'north',title:'header',split:true,noheader:true"  style="background: rgb(78, 190, 214) none repeat scroll 0% 0%; height: 60px; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">	 
		 <div class="logo">天丽图书流通信息管理系统</div>
		 <div class="logout">您好，admin<a href="newlogin.jsp">注销</a></div>  
		<!-- <div class="logout">您好，<input type=text name="name" style="width:50px;"/><a href="newlogin.jsp">注销</a></div> -->
		
	</div>
	
	<div data-options="region:'center'" >
		<!-- <!--  对应上面的queueid-->
         <div id="fileQueue"></div>  
	     <form action="servlet/Upfile" method="post" enctype="multipart/form-data">
	           <table>
	           		<tr >
	           			<td width="150"><input type="file" name="uploadify" id="uploadify" /></td>
	           			<td width="50"><a href="javascript:$('#uploadify').uploadify('upload','*')" style="color:#0000ff">上传</a></td>
	           			<td width="50"><a href="javascript:$('#uploadify').uploadify('cancel','*');" style="color:#0000ff">取消</a></td>
	           		</tr>
	           
	           </table>
         </form>
       	
  
		<div>
			<input type=button id="init" value="资源获取" onclick="initFile()" />
			<table width="100%" border="1">
				 <thead>
					<tr align="center">
						<td>文件名</td>
					    <td>存储路径</td> 
						<!-- <td>
							<a href="#" class="easyui-linkbutton"><font color="#8000ff">下载</font></a>
						</td> -->
						<!-- <td width="100">
							<input type=button id="load" value="下载" />
						</td> -->
						<td style="align:center">资源下载</td>
						
					</tr>
				</thead>
				<tbody id="myfile">
				</tbody> 
			</table>
		</div>
		<!-- <form id="down">
		复制路径：<input type="text" name="download" id="download" />  
		</form> -->	
	
	</div> 
       
   </body>    
</html>  