package com.yyj.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yyj.dao.ILoginDao;
import com.yyj.model.Admin;
@Repository("loginDao")
public class LoginDao implements ILoginDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
	public int check(String name,String password) {
		// TODO Auto-generated method stub
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

}
