package com.yyj.service;

import java.util.List;

import com.yyj.model.Admin;

public interface IAdminService {

	public void addAdmin(Admin admin);

	public int updateAdmin(Admin admin);

	public int deleteAdmin(Admin admin);

	public int deleteAdmins(List<Admin> admins);

	public Admin selectAdminById(int id);

	public List<Admin> showByPage(int pageNo, int pageSize);

	

}
