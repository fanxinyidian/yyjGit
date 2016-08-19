package com.yyj.service.impl;



import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyj.dao.IAdminFunctionDao;
import com.yyj.model.AdminFunction;
import com.yyj.service.IAdminFunctionService;

@Service("adminfunctionService")
@Transactional
public class AdminFunctionService implements IAdminFunctionService {

	@Autowired
	private IAdminFunctionDao adminfunctionDao;
	
	public void addAdminFunction(AdminFunction adminfunction) {
		// TODO Auto-generated method stub
		adminfunctionDao.addAdminFunction(adminfunction);

	}

	public AdminFunction selectAdminFunctionById(int id) {
		// TODO Auto-generated method stub
		return adminfunctionDao.selectAdminFunctionById(id);
	}

	public List<AdminFunction> showByPage(int pageNo, int pageSize) {
		return adminfunctionDao.showByPage(pageNo, pageSize);
	}
	
	public int updateAdminFunction(AdminFunction adminfunction){
		return adminfunctionDao.updateAdminFunction(adminfunction);
	}

	public int deleteAdminFunction(AdminFunction adminfunction) {
		// TODO Auto-generated method stub
		return adminfunctionDao.deleteAdminFunction(adminfunction);
	}

	public int deleteAdminFunctions(List<AdminFunction> adminfunctions) {
		// TODO Auto-generated method stub
		return adminfunctionDao.deleteAdminFunctions(adminfunctions);
	}

	
}

