package com.yyj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyj.service.ILoginService;

/**
 * @author yyj
 * @description 
 * 登录-事件处理
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private ILoginService loginService;
	
/**
 *@param request
 *@return
 *登录账户、密码验证；登录信息存入session
 */
	@RequestMapping("/check")
	@ResponseBody
	public int check(HttpServletRequest request) {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		request.getSession().setAttribute("name", name);
		//session.setAttribute("name", name);
		
		return loginService.check(name,password);
		
	}
	
}
