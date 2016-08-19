package com.yyj.service;

import java.util.List;

import com.yyj.model.Nav;

public interface INavService {
	
	public Nav selectByPrimaryKey(int id);
	
	public List<Nav> selectAll();
	
	public List<Nav> selectByNid(int nid);
	
	public  List<Nav> selectByNidLimitByAuth(int nid,int auth);
}
