package com.yyj.dwr.impl;

import java.util.List;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yyj.dwr.IDwrBookInfo;
import com.yyj.model.BookInfo;
@RemoteProxy(name="dwrBookInfo")
public class DwrBookInfo implements IDwrBookInfo {
	@Autowired
	private SessionFactory sessionFactory;
	@RemoteMethod
	public List<BookInfo> showAll(){
		String hql ="from BookInfo";
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
