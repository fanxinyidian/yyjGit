package com.yyj.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yyj.dao.ICirculateStateDao;
import com.yyj.model.CirculateState;

@Repository("circulatestateDao")
public class CirculateStateDao implements ICirculateStateDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void addCirculateState(CirculateState circulatestate) {
		// TODO Auto-generated method stub
		 this.getCurrentSession().save(circulatestate);
	}

	public CirculateState selectCirculateStateById(int id) {
		// TODO Auto-generated method stub
		return (CirculateState) this.getCurrentSession().get(CirculateState.class,id);
	}

	public List<CirculateState> showByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql ="from CirculateState";
		Query query=this.getCurrentSession().createQuery(hql);
		query.setFirstResult((pageNo-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	public int updateCirculateState(CirculateState circulatestate) {
		// TODO Auto-generated method stub
		this.getCurrentSession().update(circulatestate);
		return 1;
	}
	
	public int deleteCirculateState(CirculateState circulatestate){
		this.getCurrentSession().delete(circulatestate);
		return 1;
	}
	
	public int deleteCirculateStates(List<CirculateState> circulatestates){
		return 1;
	}
	
	

}

