package com.yyj.service;

import java.util.List;

import com.yyj.model.AdminFunction;

public interface IAdminFunctionService {

	public void addAdminFunction(AdminFunction adminfunction);

	public int updateAdminFunction(AdminFunction adminfunction);

	public int deleteAdminFunction(AdminFunction adminfunction);

	public int deleteAdminFunctions(List<AdminFunction> adminfunctions);

	public AdminFunction selectAdminFunctionById(int id);

	public List<AdminFunction> showByPage(int pageNo, int pageSize);

	

}
