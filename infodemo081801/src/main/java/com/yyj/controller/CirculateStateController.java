package com.yyj.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.yyj.model.Admin;
import com.yyj.model.CirculateState;
import com.yyj.model.CirculateStateTo;
import com.yyj.service.ICirculateStateService;

/**
 * @author yyj
 * @description 
 * 书籍流通管理-事件处理
 */
@Controller
@RequestMapping("/circulatestate")
public class CirculateStateController {
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd"); 
	 
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private ICirculateStateService circulatestateService;
/** 
 *@param id
 *@return
 *流通信息-获取：按表格勾选行获取书籍流通信息
 *日期格式转换：增加CirculateStateTo配合CirculateState类
 *			实现add，update过程中日期格式转换
 */
	@RequestMapping("/get")
	@ResponseBody
	public CirculateStateTo getCirculateState(Integer id) {
		CirculateStateTo circulateTo=new CirculateStateTo();
		if(id!=null){
			CirculateState circulate=circulatestateService.selectCirculateStateById(id);
			circulateTo.setId(circulate.getId());
			circulateTo.setCode(circulate.getCode());
			circulateTo.setBorrowName(circulate.getBorrowName());
			circulateTo.setStatu(circulate.getStatu());
			
			circulateTo.setStartTime(new SimpleDateFormat("yyyyMMdd").format(circulate.getStartTime()));
			circulateTo.setEndTime(new SimpleDateFormat("yyyyMMdd").format(circulate.getEndTime()));
		}
		return circulateTo;
	}

/**
 *@param request
 *@return
 *流通信息-加载：按pagination加载展示流通信息数据
 */
	@RequestMapping("/showPage")
	@ResponseBody
	public List<CirculateStateTo> getCirculateStatesByPage(HttpServletRequest request) {
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		if (null == page || rows == null)
			return null;

		List<CirculateState> circulatestates = circulatestateService.showByPage(Integer.parseInt(page), Integer.parseInt(rows));
		List<CirculateStateTo> circulatestatesConvert=new ArrayList<CirculateStateTo>();
		for(CirculateState circulatestate: circulatestates){
			CirculateStateTo circulateTo=new CirculateStateTo();
			circulateTo.setId(circulatestate.getId());
			circulateTo.setCode(circulatestate.getCode());
			circulateTo.setStatu(circulatestate.getStatu());
			circulateTo.setBorrowName(circulatestate.getBorrowName());
			circulateTo.setStartTime(new SimpleDateFormat("yyyyMMdd").format(circulatestate.getStartTime()));
			circulateTo.setEndTime(new SimpleDateFormat("yyyyMMdd").format(circulatestate.getEndTime()));
			circulatestatesConvert.add(circulateTo);
			
		}
		
		return circulatestatesConvert;
	}
	
/**
 *@param request
 *@return
 *@throws ParseException
 *流通信息-查询：按条件查询流通信息
 */
	@RequestMapping("/showSearch")
	@ResponseBody
	public List<CirculateStateTo> getCirculateStatesBySearch(HttpServletRequest request) throws ParseException {
		String borrowName = request.getParameter("borrowName");
		String code = request.getParameter("code");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String startTimeTo="";
		String endTimeTo="";
		for(int i=0;i<startTime.length();i++){
			if(startTime.charAt(i)!='-'){
				startTimeTo+=startTime.charAt(i);
			}
		}
		
		for(int i=0;i<endTime.length();i++){
			if(endTimeTo.charAt(i)!='-'){
				endTimeTo+=endTime.charAt(i);
			}
		}
		String statu = request.getParameter("statu");
		String hql="from CirculateState";
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		List<CirculateState> lst=query.list();
		List<CirculateState> tem=new ArrayList<CirculateState>();
		for(int i=0;i<lst.size();i++){
			if(lst.get(i).getBorrowName().equals(borrowName)||lst.get(i).getCode().equals(code)
				||lst.get(i).getStatu().equals(statu)||sdf.format(lst.get(i).getStartTime()).equals(startTimeTo)||sdf.format(lst.get(i).getEndTime()).equals(endTimeTo)){
				tem.add(lst.get(i));
				
				}			
		}
		
		List<CirculateState> circulatestates=tem;
		List<CirculateStateTo> circulatestatesConvert=new ArrayList<CirculateStateTo>();
		for(CirculateState circulatestate: circulatestates){
			CirculateStateTo circulateTo=new CirculateStateTo();
			circulateTo.setId(circulatestate.getId());
			circulateTo.setCode(circulatestate.getCode());
			circulateTo.setStatu(circulatestate.getStatu());
			circulateTo.setBorrowName(circulatestate.getBorrowName());
			circulateTo.setStartTime(new SimpleDateFormat("yyyyMMdd").format(circulatestate.getStartTime()));
			circulateTo.setEndTime(new SimpleDateFormat("yyyyMMdd").format(circulatestate.getEndTime()));
			circulatestatesConvert.add(circulateTo);
			
		}
		
		return circulatestatesConvert;
	}

/**
 *@param request
 *@return
 *@throws ParseException
 *流通信息-添加
 */
	@RequestMapping("/add")
	@ResponseBody
	public Integer add(HttpServletRequest request) throws ParseException {
		String code = request.getParameter("code");
		String borrowName = request.getParameter("borrowName");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String statu = request.getParameter("statu");

		CirculateState 	circulatestate = new CirculateState(code, borrowName, sdf.parse(startTime),sdf.parse(endTime),statu);
		try {
			circulatestateService.addCirculateState(circulatestate);
			return 2;
		} catch (Exception e) {
			return 0;
		}
		
	}

/**
 *@param request
 *@return
 *@throws NumberFormatException
 *@throws ParseException
 *流通信息-更新
 */
	@RequestMapping("/update")
	@ResponseBody
	public Integer update(HttpServletRequest request) throws NumberFormatException, ParseException {
		String id = request.getParameter("id");
		String code=request.getParameter("code");
		String borrowName = request.getParameter("borrowName");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String statu=request.getParameter("statu");
		CirculateState circulatestate = new CirculateState(Integer.parseInt(id), code, borrowName, sdf.parse(startTime),sdf.parse(endTime),statu);
		try {
			return circulatestateService.updateCirculateState(circulatestate);
		} catch (Exception e) {
			return 0;
		}
	}

/**
 *@param request
 *@return
 *流通信息-单选删除
 */
	@RequestMapping("/deleteId")
	@ResponseBody
	public Integer delete(HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			CirculateState circulatestate = circulatestateService.selectCirculateStateById(Integer.parseInt(id));
			return circulatestateService.deleteCirculateState(circulatestate);
		} catch (Exception e) {
			return 0;
		}
	}

/** 
 *@param request
 *@return
 *流通信息-多选删除
 */
	@RequestMapping("/deleteIds")
	@ResponseBody
	public Integer deleteIds(HttpServletRequest request) {
		try {
			String ids = request.getParameter("ids");
			String[] tempTds = ids.split(",");
			for (String id : tempTds) {
				CirculateState circulatestate = circulatestateService.selectCirculateStateById(Integer.parseInt(id));
				circulatestateService.deleteCirculateState(circulatestate);
			}
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
}

