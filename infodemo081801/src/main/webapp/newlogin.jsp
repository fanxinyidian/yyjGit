<%@page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
<head id="Head1" runat="server">
 	 <title>天丽图书流通信息管理系统</title>
	 <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
	 <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
     
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js" ></script>
	
 	<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/engine.js"> </script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/util.js"> </script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/interface/dwrLogin.js"> </script>
	<!-- <script type="text/javascript" src="js/newdwrlogin.js"></script> -->
	<script type="text/javascript" src="js/login.js"></script>
    <style type="text/css">
       /* css reset */
			body{color:#000;background:#fff;font-size:12px;line-height:166.6%;text-align:center;}
			body,input,select,button{font-family:verdana}
			h1,h2,h3,select,input,button{font-size:100%}
			body,h1,h2,h3,ul,li,form,p,img{margin:0;padding:0;border:0}
			img{margin:0;line-height:normal}
			select{padding:1px}
			select,input,button,button img,label{vertical-align:middle;
                width: 171px;
                height: 36px;
            }
            #IsRemember{vertical-align:middle; width: 15px; height: 15px;}
			header,footer,section,aside,nav,hgroup,figure,figcaption{display:block;margin:0;padding:0;border:none}
			a{text-decoration:none;color:#848585}
			a:hover{color:#000}
			.fontWeight{font-weight:700;}
			/* backgroundImage */
			.headerIntro,
			.themeText li,
			.domain,
			.whatAutologin,
			.ico,
			.ext,
			.headerLogo,
			.headerIntro,
			.headerNav,		
			.footerLogo,
			.footerNav,		
			.domain{position:absolute}
			
			/* header */
			.header{width:800px;height:64px;position:relative;margin:0 auto;z-index:2;overflow:hidden;}
			.headerLogo{top:17px;left:0px}
			.headerIntro{height:28px;width:160px;display:block;background-position:0 -64px;top:17px;left:144px}
			.headerNav{top:30px;right:0px;width:300px;text-align:right}
			.headerNav a{margin-left:13px}
		
			/* main */
			.main{height:440px;margin:0 auto;background:#fff;}
			.main-inner{width:900px;height:440px;overflow:visible;margin:0 auto;position:relative;clear:both}
			#theme
			{height:440px;width:900px;position:absolute;overflow:hidden;z-index:1;background-position:top right;background-repeat:no-repeat;text-align:left;top:0;left:0;}
			.themeLink{height:274px;width:430px;display:block;outline:0;}
			.themeText{margin-left:26px;}
			.themeText li{line-height:22px;-line-height:24px;height:24px;color:#858686;text-indent:12px;background-position:-756px -72px;background-repeat:no-repeat}
			.themeText li a{color:#005590;text-decoration:underline;}
			.unishadow{box-shadow:0px 1px 3px 0 rgba(0,0,0,0.2);-webkit-box-shadow:0px 1px 3px 0 rgba(0,0,0,0.2);-moz-box-shadow:0px 1px 3px 0 rgba(0,0,0,0.2);}
					
			/* footer */
			.footer{height:65px;margin:0 auto;background:#f7f7f7;border-top:1px solid #fff;}
			.footer-inner{width:900px;height:63px;overflow:hidden;margin:0 auto;color:#848585;position:relative;background:#f7f7f7;
                top: 0px;
                left: 0px;
            }
			.footerLogo{top:11px;left:35px}
			.footerNav{top:25px;right:126px;}
			.footerNav a{margin-left:8px}
			.copyright{margin-left:22px}		
			#themeArea{width:240px;height:80px;position:absolute;left:90px;top:134px;}
		
			#theme{-webkit-transition:all 1s ease;-moz-transition:all 1s ease;transition:all 1s ease;background:none;}
			#theme.themeEffect{background:#e7ebe9;}
			.login{width:300px;height:300px;overflow:;float:right;margin-right:70px;margin-top:35px;background:#fff;border:1px solid #afc2af;_display:inline;text-align:left;position:relative;z-index:2;border-radius:2px;}
			.login{box-shadow:0px 1px 3px 0 rgba(0,0,0,0.2);-webkit-box-shadow:0px 1px 3px 0 rgba(0,0,0,0.2);-moz-box-shadow:0px 1px 3px 0 rgba(0,0,0,0.2);}
		    .tab-1{background:none;}
		    .style1
            {
                width: 102px;
                height: 48px;
                margin-left:10px;
            }
		    .style2
            {
                width: 102px;
                height: 25px;
            }
            .style3
            {
                height: 25px;
            }
            .style5
            {
                width: 102px;
                height: 62px;
            }
            .style7
            {
                height: 48px;
            }
            .style8
            {
                height: 77px;
            }
            .style9
            {
                height: 62px;
            }
            #divMain{ display:block;margin:0;padding:0;border:none ;height:440px;margin:0 auto;background:#f7f7f7; 
                       background-position:inherit; background-repeat:repeat-x;}
                       /* background-image:url('Img/w.jpg'); */
    </style>
</head>
<body> 
    <div style="height:56px; width:900px; margin:0 auto;">
		<div style="float:left;width:40%; display:inline ;line-height:24px;line-height:24px;valign:center">
			<tr>
				<td>
					<a>
						 <img src="easyui/themes/gray/images/theme2.jpg" alt="telek" width="64" height="45">  	
					</a>
				</td>
				<td valign="middle">
					<font size="5" color="#0000ff">
						 天丽图书流通信息管理系统
					</font>
				</td>
		</tr>
		
		</div>
        <div style="clear:both;"></div>
	</div>
    <form id="Form1" method="post" runat="server" defaultfocus="TB_No">
    <section class="main" id="mainBg">
     <div id="divMain" style="background-repeat:repeat-x; width:100%; background-position:left; display:block;margin:0;padding:0;border:none" >
		<div class="main-inner" 
             style="  background-position: center top; background-repeat:repeat-x; top: 0px; left: 0px;" >
			<div id="theme">
            <!-- <img src="img/back.png" style=" height:440px; width:900px;" /> -->
            	<img src="easyui/themes/gray/images/back.png" style=" height:440px; width:1200px;" />
            </div>
			<div id="loginBlock" class="login tab-1">
            <table  style="color: blue; background-color: rgb(241, 243, 248);" width="310" height="309">
            <tr >
	             <td colspan="2" class="style8"><font color="#8e8eff"> 
	              &nbsp;&nbsp;<img src="easyui/themes/gray/images/user1.png" style="width: 29px; height: 17px;"> 
	              <strong style="font-size: 16px;"> 账户登录</strong></font>
	              <hr style="width:100%; height:0.5px; color:Black" />
	            </td>
            </tr>
            <tr>
                <td class="style6">
                	<font color="#8e8eff">&nbsp;&nbsp;</font>
	                 <cc1:lab ID="Lab1" runat="server">
						<font size="2" color="#8e8eff">&nbsp;&nbsp;<b>管理员账号</b></font>
	                 </cc1:lab>
                </td>
                <td >
                  
                     <font color="#8e8eff"><input type="text" id="name" name="name_edit" class="textbox"></font>
                </td>
            </tr>
             <tr>
                <td >
	                <font color="#8e8eff"> &nbsp;&nbsp;</font> 
	                 <cc1:lab ID="Lab2" runat="server">
						<font size="2" color="#8e8eff">&nbsp;&nbsp;<b>管理员密码</b></font>
					</cc1:lab> 	
                </td>
                <td>                
	                 <input type="password" id="password" name="password_edit" class="textbox">       
	                <font color="#8e8eff"><br></font>
                </td>
             </tr>
               <tr  style="text-align:center">   
                 <td colspan="2" class="style6">
                  		<div id="btn">
	 						<a href="#" class="easyui-linkbutton" style="width: 70px; height: 30px;"><font color="#16aaf1">登 录</font></a> 
						</div> 
                   <!-- color="#8000ff" -->
                   <!-- <font color="#8e8eff"><input type="button" value="登   录" style="background-color:#16aaf1;width: 70px; height: 30px;" onclick="login()"></font> -->                     
                 </td>                 
               </tr>
               <tr>
               <td></td><td></td>
               </tr>
            </table>            
		</div>
      </div>
      
	</section>
    <footer id="footer" class="footer">
		<div class="footer-inner" id="footerInner">			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>北京京杭天丽科技有限公司  |telek yyj &copy; 2016</span>&nbsp;&nbsp;
		</div>
	</footer>
    </form>
</body>
</html>