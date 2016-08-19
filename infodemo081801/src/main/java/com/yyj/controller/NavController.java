package com.yyj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyj.model.Admin;
import com.yyj.model.AdminFunction;
import com.yyj.model.Nav;
import com.yyj.service.IAdminService;
import com.yyj.service.INavService;

/**
 * @author yyj
 * @description 
 * tree异步加载-从数据库中加载tree
 */
@Controller
@RequestMapping("/nav")
public class NavController {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private INavService navService;
	@Autowired
	private IAdminService adminService;
	int tag=0;
/** 
 *@param id
 *@return
 *按父节点选择加载节点：easyui-tree自动获取节点id
 */
	@RequestMapping("/getByNid")
	@ResponseBody
	public  List<Nav> getByNid(Integer id){
		
		if(id==null) id=0;
		return navService.selectByNid(id);
	}
	
/**	
 *@param session
 *@param nid
 *@return
 *按权限限制加载tree:通过获取session中的登录信息，
 *				    将账户与权限关联，实现按权限等级加载tree
 */
	@RequestMapping("/getByNid2")
	@ResponseBody
	public  List<Nav> getByNidAndAuth(Integer id,HttpSession session){
		
			if(id==null){
				id=0;
			}
			/*从session中获取登录信息*/
			String name=(String)session.getAttribute("name");
			//String name="myl";
			String hql="from AdminFunction af where af.adminname=:myname";
			Query query=this.sessionFactory.getCurrentSession().createQuery(hql).setParameter("myname", name);
			List<AdminFunction> lst=query.list();
			int auth=0;
			if(!lst.isEmpty()){
			 auth=lst.get(0).getFunctions();
			 }
			
			/*从数据库查询用户信息，拿到权限auth*/
			//Admin admin=adminService.selectAdminByName("yyj");
			//int auth=admin.getAuth();//从用户信息拿到,用户表加一个字段auth
			
			return navService.selectByNidLimitByAuth(id, auth);
		
	}
	
	
}
