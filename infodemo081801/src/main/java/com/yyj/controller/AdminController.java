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
import com.yyj.model.BookInfo;

import com.yyj.service.IAdminService;

/**
 * @author yyj
 * @description
 * 系统账户信息-事件处理
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
	@Autowired
	private IAdminService adminService;
	
/**
 * @param id
 * @return
 * 账户信息-获取：按表格勾选行获取账户信息
 */
	@RequestMapping("/get")
	@ResponseBody
	public Admin getAdmin(Integer id) {
		if (null == id)
			return null;
		Admin admin = adminService.selectAdminById(id);
		return admin;
	}
	
/**
 * @param request
 * @return
 * 账户信息-加载：按pagination加载展示账户信息数据
 */
	@RequestMapping("/showPage")
	@ResponseBody
	public List<Admin> getAdminsByPage(HttpServletRequest request) {
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		if (null == page || rows == null)
			return null;

		List<Admin> admins = adminService.showByPage(Integer.parseInt(page), Integer.parseInt(rows));
		return admins;
	}

/**
 * @param request
 * @return
 * 账户信息-查询：按条件查询账户信息
 */
	@RequestMapping("/showSearch")
	@ResponseBody
	public List<Admin> getAdminsBySearch(HttpServletRequest request) {
		String name = request.getParameter("name");
		String hql="from Admin";
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		List<Admin> lst=query.list();
		List<Admin> admins=lst;
		List<Admin> tem=new ArrayList<Admin>();
		for(int i=0;i<admins.size();i++){
			if(admins.get(i).getName().equals(name)){
				tem.add(admins.get(i));
				}			
		}
		return tem;
	}

/**
 *@param request
 *@return
 *账户信息-添加
 */
	@RequestMapping("/add")
	@ResponseBody
	public Integer add(HttpServletRequest request) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		Admin admin = new Admin(name, password);
		try {
			adminService.addAdmin(admin);
			return 2;
		} catch (Exception e) {
			return 0;
		}
	}

/**
 *@param request
 *@return
 *账户信息-更新
 */
	@RequestMapping("/update")
	@ResponseBody
	public Integer update(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		Admin admin = new Admin(Integer.parseInt(id),name, password);
		try {
			return adminService.updateAdmin(admin);
		} catch (Exception e) {
			return 0;
		}
	}

/**
 *@param request
 *@return
 *账户信息-单选删除
 */
	@RequestMapping("/deleteId")
	@ResponseBody
	public Integer delete(HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			Admin admin = adminService.selectAdminById(Integer.parseInt(id));
			return adminService.deleteAdmin(admin);
		} catch (Exception e) {
			return 0;
		}
	}
	
/**
 * @param request
 * @return
 * 账户信息-多选删除
 */
	@RequestMapping("/deleteIds")
	@ResponseBody
	public Integer deleteIds(HttpServletRequest request) {
		try {
			String ids = request.getParameter("ids");
			String[] tempTds = ids.split(",");
			for (String id : tempTds) {
				Admin admin = adminService.selectAdminById(Integer.parseInt(id));
				adminService.deleteAdmin(admin);
			}
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	
/**
 * dwr测试样例
 */
  /*@RemoteMethod
	@RequestMapping("/check")
	@ResponseBody
	public int check(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		测试0
			//if(admin.getName().equals("yyj")&&admin.getPassword().equals("12345"))
			//	return 1;
			//else return 0;
			
			//List<Admin> admins=this.showAll();
		测试1
			List<Admin> admins=new ArrayList<Admin>();
			admins.add(new Admin("yyj","12345"));
			admins.add(new Admin("ly","12345"));
			//Admin admin1=new Admin(int idString name, String password);
		测试2
			List<Admin> admins=this.showAll1();
			for(int i=0;i<admins.size();i++){
				if(admins.get(i).getName().equals(admin.getName())&&admins.get(i).getPassword().equals(admin.getPassword())){
					return 1;
					}
			}
			return 0;
		测试3
			List<Admin> admins=this.showAll();
			for(int i=0;i<admins.size();i++){
				if(admins.get(i).getName().equals(name)&&admins.get(i).getPassword().equals(password)){
					return 1;
					}
				
			}
			return 0;
		
	}
	测试4
	public List<Admin> showAll() {
		// TODO Auto-generated method stub
		//String hql="select A.name, A.password from Admin as A";
		String hql="from Admin";
		Query query=this.getCurrentSession().createQuery(hql);
		List<Admin> lst=query.list();
		return lst;
	}
	测试5
	public List<Admin> showAll1(){
		String sql="select * from admin";
		this.jt=new JdbcTemplate(dataSource);
		List<Admin> lst=this.jt.queryForList(sql, Admin.class);
		return lst;
	}*/

}

