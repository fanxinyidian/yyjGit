package com.yyj.service.impl;



import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyj.dao.IAdminDao;
import com.yyj.model.Admin;
import com.yyj.service.IAdminService;

@Service("adminService")
@Transactional
public class AdminService implements IAdminService {

	@Autowired
	private IAdminDao adminDao;
	
	public void addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.addAdmin(admin);

	}

	public Admin selectAdminById(int id) {
		// TODO Auto-generated method stub
		return adminDao.selectAdminById(id);
	}

	public List<Admin> showByPage(int pageNo, int pageSize) {
		return adminDao.showByPage(pageNo, pageSize);
	}
	
	public int updateAdmin(Admin admin){
		return adminDao.updateAdmin(admin);
	}

	public int deleteAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.deleteAdmin(admin);
	}

	public int deleteAdmins(List<Admin> admins) {
		// TODO Auto-generated method stub
		return adminDao.deleteAdmins(admins);
	}

	

}

