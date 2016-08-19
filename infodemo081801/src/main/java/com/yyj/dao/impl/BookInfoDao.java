package com.yyj.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yyj.dao.IBookInfoDao;
import com.yyj.model.BookInfo;

@Repository("bookinfoDao")
public class BookInfoDao implements IBookInfoDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void addBookInfo(BookInfo bookinfo) {
		// TODO Auto-generated method stub
		 this.getCurrentSession().save(bookinfo);
	}

	public BookInfo selectBookInfoById(int id) {
		// TODO Auto-generated method stub
		return (BookInfo) this.getCurrentSession().get(BookInfo.class,id);
	}

	public List<BookInfo> showByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql ="from BookInfo";
		Query query=this.getCurrentSession().createQuery(hql);
		query.setFirstResult((pageNo-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	public int updateBookInfo(BookInfo bookinfo) {
		// TODO Auto-generated method stub
		this.getCurrentSession().update(bookinfo);
		return 1;
	}
	
	public int deleteBookInfo(BookInfo bookinfo){
		this.getCurrentSession().delete(bookinfo);
		return 1;
	}
	
	public int deleteBookInfos(List<BookInfo> bookinfos){
		return 1;
	}
	
	

}

