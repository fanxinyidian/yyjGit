package com.yyj.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yyj.dao.IAdminFunctionDao;
import com.yyj.model.AdminFunction;;

@Repository("adminfunctionDao")
public class AdminFunctionDao implements IAdminFunctionDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void addAdminFunction(AdminFunction adminfunction) {
		// TODO Auto-generated method stub
		 this.getCurrentSession().save(adminfunction);
	}

	public AdminFunction selectAdminFunctionById(int id) {
		// TODO Auto-generated method stub
		return (AdminFunction) this.getCurrentSession().get(AdminFunction.class,id);
	}

	public List<AdminFunction> showByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql ="from AdminFunction";
		Query query=this.getCurrentSession().createQuery(hql);
		query.setFirstResult((pageNo-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	public int updateAdminFunction(AdminFunction adminfunction) {
		// TODO Auto-generated method stub
		this.getCurrentSession().update(adminfunction);
		return 1;
	}
	
	public int deleteAdminFunction(AdminFunction adminfunction){
		this.getCurrentSession().delete(adminfunction);
		return 1;
	}
	
	public int deleteAdminFunctions(List<AdminFunction> adminfunctions){
		return 1;
	}

	
	
	

}

