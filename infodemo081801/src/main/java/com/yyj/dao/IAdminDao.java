package com.yyj.dao;

import java.util.List;

import com.yyj.model.Admin;;

public interface IAdminDao {
	
	public void addAdmin(Admin admin);
	
	public int updateAdmin(Admin admin);
	
	public int deleteAdmin(Admin admin);
	
	public int deleteAdmins(List<Admin> admins);
	
	public Admin selectAdminById(int id);
	
	public List<Admin> showByPage(int pageNo,int pageSize);
	
	
	

}
