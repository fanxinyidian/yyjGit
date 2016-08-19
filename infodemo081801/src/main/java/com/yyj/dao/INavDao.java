package com.yyj.dao;

import java.util.List;

import com.yyj.model.Nav;


public interface INavDao {
	
	public Nav selectByPrimaryKey(int id);
	
	public List<Nav> selectAll();
	
	public List<Nav> selectByNid(int nid);
	
	public  List<Nav> selectByNidLimitByAuth(int nid,int auth);
}
