package com.yyj.dao;

import java.util.List;

import com.yyj.model.AdminFunction;;

public interface IAdminFunctionDao {
	
	public void addAdminFunction(AdminFunction adminfunction);
	
	public int updateAdminFunction(AdminFunction adminfunction);
	
	public int deleteAdminFunction(AdminFunction adminfunction);
	
	public int deleteAdminFunctions(List<AdminFunction> adminfunctions);
	
	public AdminFunction selectAdminFunctionById(int id);
	
	public List<AdminFunction> showByPage(int pageNo,int pageSize);
	
	
	

}
