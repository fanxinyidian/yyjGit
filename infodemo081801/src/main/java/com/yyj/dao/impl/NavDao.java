package com.yyj.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yyj.dao.INavDao;
import com.yyj.model.BookInfo;
import com.yyj.model.Nav;
@Repository("navDao")
public class NavDao implements INavDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
	@Override
	public Nav selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		
		String hql="from Nav n where n.id=:myid";
		Query query=this.getCurrentSession().createQuery(hql).setParameter("myid", id);
		List<Nav> lst=query.list();
		return lst.get(0);
		//return (Nav) this.sessionFactory.getCurrentSession().get(Nav.class,id);
	}

	@Override
	public List<Nav> selectAll() {
		// TODO Auto-generated method stub
		
		String hql="from Nav";
		Query query=this.getCurrentSession().createQuery(hql);
		List<Nav> lst=query.list();
		return  lst;
	}

	@Override
	public List<Nav> selectByNid(int id) {
		// TODO Auto-generated method stub
		/*String hql="";
		Query query=this.getCurrentSession().createQuery(hql);
		if(nid==0){
			 hql="from Nav n where n.nid=0";
			 query=this.getCurrentSession().createQuery(hql);
		}else{
			hql="from Nav n where n.nid=:mynid";
			 query=this.getCurrentSession().createQuery(hql).setParameter("mynid", nid);
		}*/
		String hql="from Nav n where n.nid=:myid";
		Query query=this.getCurrentSession().createQuery(hql).setParameter("myid", id);;
		List<Nav> lst=query.list();
		return lst;
	}
	@Override
	public List<Nav> selectByNidLimitByAuth(int nid, int auth) {
		// TODO Auto-generated method stub
		String hql="from Nav n where n.nid=:mynid and n.auth<=:myauth";
		Query query=this.getCurrentSession().createQuery(hql).setParameter("mynid", nid).setParameter("myauth", auth);
		List<Nav> lst=query.list();
		return lst;
	}
	
}
