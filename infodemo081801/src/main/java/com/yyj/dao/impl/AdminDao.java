package com.yyj.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yyj.dao.IAdminDao;
import com.yyj.model.Admin;;

@Repository("adminDao")
public class AdminDao implements IAdminDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		 this.getCurrentSession().save(admin);
	}

	public Admin selectAdminById(int id) {
		// TODO Auto-generated method stub
		return (Admin) this.getCurrentSession().get(Admin.class,id);
	}

	public List<Admin> showByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql ="from Admin";
		Query query=this.getCurrentSession().createQuery(hql);
		query.setFirstResult((pageNo-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	public int updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		this.getCurrentSession().update(admin);
		return 1;
	}
	
	public int deleteAdmin(Admin admin){
		this.getCurrentSession().delete(admin);
		return 1;
	}
	
	public int deleteAdmins(List<Admin> admins){
		return 1;
	}

	
	
	

}

