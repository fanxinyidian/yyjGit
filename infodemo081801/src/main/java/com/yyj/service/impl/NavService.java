package com.yyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyj.dao.INavDao;
import com.yyj.model.Nav;
import com.yyj.service.INavService;

@Service("navService")
@Transactional
public class NavService implements INavService{
	
	@Autowired
	private INavDao navDao;
	
	@Override
	public Nav selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return navDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Nav> selectAll() {
		// TODO Auto-generated method stub
		return navDao.selectAll();
	}

	@Override
	public List<Nav> selectByNid(int nid) {
		// TODO Auto-generated method stub
		return navDao.selectByNid(nid);
	}

	@Override
	public List<Nav> selectByNidLimitByAuth(int nid, int auth) {
		// TODO Auto-generated method stub
		return navDao.selectByNidLimitByAuth(nid, auth);
	}

}
