//关键-》获取alert（data）返回值的方法
function test(){
     var result;
     
     dwr.engine.setAsync(false);
     var a = dwr.util.getValue("name");
     var b = dwr.util.getValue("password");
     //dwrLogin.check($('#name').val(),$('#password').val(),function(data){result=data});
     dwrLogin.check(a,b,function(data){result=data});
     dwr.engine.setAsync(true);
     return result;
}
	
//执行		
function login(){				
			var re=test();
			//alert(re);
			if (re > 0) {
				location.href = 'admin.jsp';
			} else {
				$.messager.alert('登录失败！', '用户名或密码错误！', 'warning', function () {
					$('#password').select();
				});
			}
		}









