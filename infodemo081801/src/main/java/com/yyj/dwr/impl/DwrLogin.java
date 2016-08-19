package com.yyj.dwr.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.java.swing.plaf.windows.resources.windows;
import com.yyj.dwr.IDwrLogin;
import com.yyj.model.Admin;

/**
 * @author yyj
 * @description 
 * dwr登录-事件处理
 */
@RemoteProxy(name="dwrLogin")
public class DwrLogin implements IDwrLogin {
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 登录账户-信息校验
	 */
	@RemoteMethod
	public int check(String name,String password) throws IOException{
		String hql="from Admin";
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		List<Admin> lst=query.list();
		List<Admin> admins=lst;
		for(int i=0;i<admins.size();i++){
			if(admins.get(i).getName().equals(name)&&admins.get(i).getPassword().equals(password)){
				return 1;
			}	
		}
		return 0;
	}
	
	//测试
	public int test(){
		return 10;
	}
}
