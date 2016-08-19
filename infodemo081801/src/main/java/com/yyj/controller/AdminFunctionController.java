package com.yyj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.hibernate.Query;
import javax.sql.DataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mchange.v1.db.sql.CBPUtils;
import com.yyj.model.Admin;
import com.yyj.model.AdminFunction;
import com.yyj.model.BookInfo;

import com.yyj.service.IAdminFunctionService;

/**
 * @author yyj
 * @description 
 * 用户-权限
 * 分配管理
 */
@Controller
@RequestMapping("/adminfunction")
public class AdminFunctionController {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Autowired
	private IAdminFunctionService adminfunctionService;

/**
 * 
 *@param id
 *@return
 *用户权限信息-获取：按表格勾选行获取用户权限信息
 */
	@RequestMapping("/get")
	@ResponseBody
	public AdminFunction getAdminFunction(Integer id) {
		if (null == id)
			return null;
		AdminFunction adminfunction = adminfunctionService.selectAdminFunctionById(id);
		return adminfunction;
	}

/**
 *@param request
 *@return
 *用户权限信息-加载：按pagination加载展示用户权限数据
 */
	@RequestMapping("/showPage")
	@ResponseBody
	public List<AdminFunction> getAdminsByPage(HttpServletRequest request) {
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		if (null == page || rows == null)
			return null;

		List<AdminFunction> adminfunctions = adminfunctionService.showByPage(Integer.parseInt(page), Integer.parseInt(rows));
		return adminfunctions;
	}
	
/**
 *@param request
 *@return
 *用户权限信息-按条件查询
 */
	@RequestMapping("/showSearch")
	@ResponseBody
	public List<AdminFunction> getAdminFunctionsBySearch(HttpServletRequest request) {
		String adminname = request.getParameter("adminname");
		String functions = request.getParameter("functions");
		
		String hql="from AdminFunction";
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		List<AdminFunction> lst=query.list();
		List<AdminFunction> adminfunctions=lst;
		List<AdminFunction> tem=new ArrayList<AdminFunction>();
		for(int i=0;i<adminfunctions.size();i++){
			if(adminfunctions.get(i).getAdminname().equals(adminname)||adminfunctions.get(i).getFunctions()==Integer.parseInt(functions)){
				tem.add(adminfunctions.get(i));
				
				}			
		}
		return tem;
	}
	
/**
 *@param request
 *@return
 *用户权限信息-添加
 */
	@RequestMapping("/add")
	@ResponseBody
	public Integer add(HttpServletRequest request) {
		String adminname = request.getParameter("adminname");
		String functions = request.getParameter("functions");
		
		AdminFunction adminfunction = new AdminFunction(adminname, Integer.parseInt(functions));
		try {
			adminfunctionService.addAdminFunction(adminfunction);
			return 2;
		} catch (Exception e) {
			return 0;
		}
	}

/**
 *@param request
 *@return
 *用户权限信息-更新
 */
	@RequestMapping("/update")
	@ResponseBody
	public Integer update(HttpServletRequest request) {
		String id = request.getParameter("id");
		String adminname = request.getParameter("adminname");
		String functions = request.getParameter("functions");
		
		AdminFunction adminfunction = new AdminFunction(Integer.parseInt(id), adminname, Integer.parseInt(functions));
		try {
			return adminfunctionService.updateAdminFunction(adminfunction);
		} catch (Exception e) {
			return 0;
		}
	}
	
/**
 *@param request
 *@return
 *用户权限信息-单选删除
 */
	@RequestMapping("/deleteId")
	@ResponseBody
	public Integer delete(HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			AdminFunction adminfunction = adminfunctionService.selectAdminFunctionById(Integer.parseInt(id));
			return adminfunctionService.deleteAdminFunction(adminfunction);
		} catch (Exception e) {
			return 0;
		}
	}

/**
 *@param request
 *@return
 *用户权限信息-多选删除
 */
	@RequestMapping("/deleteIds")
	@ResponseBody
	public Integer deleteIds(HttpServletRequest request) {
		try {
			String ids = request.getParameter("ids");
			String[] tempTds = ids.split(",");
			for (String id : tempTds) {
				AdminFunction adminfunction = adminfunctionService.selectAdminFunctionById(Integer.parseInt(id));
				adminfunctionService.deleteAdminFunction(adminfunction);
			}
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
}

