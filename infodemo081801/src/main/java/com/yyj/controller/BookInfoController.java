package com.yyj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yyj.model.BookInfo;
import com.yyj.service.IBookInfoService;


/**
 * @author yyj
 * @description
 * 书籍信息管理-事件处理 
 */
@Controller
@RequestMapping("/bookinfo")
public class BookInfoController {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private IBookInfoService bookinfoService;

/**
 * @param id
 * @return
 * 书籍信息-获取：按表格勾选行获取书籍信息
 */
	@RequestMapping("/get")
	@ResponseBody
	public BookInfo getBookInfo(Integer id) {
		if (null == id)
			return null;
		BookInfo bookinfo = bookinfoService.selectBookInfoById(id);
		return bookinfo;
	}

/**
 * @param request
 * @return
 * 书籍信息-加载：按pagination加载展示书籍信息数据
 */
	@RequestMapping("/showPage")
	@ResponseBody
	public List<BookInfo> getBookInfosByPage(HttpServletRequest request) {
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		if (null == page || rows == null)
			return null;

		List<BookInfo> bookinfos = bookinfoService.showByPage(Integer.parseInt(page), Integer.parseInt(rows));
		return bookinfos;
	}
	
/**
 *@param request
 *@return
 *书籍信息-查询：按条件查询书籍信息
 */
	@RequestMapping("/showSearch")
	@ResponseBody
	public List<BookInfo> getBookInfosBySearch(HttpServletRequest request) {
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String hql="from BookInfo";
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		List<BookInfo> lst=query.list();
		List<BookInfo> bookinfos=lst;
		List<BookInfo> tem=new ArrayList<BookInfo>();
		for(int i=0;i<bookinfos.size();i++){
			if(bookinfos.get(i).getAuthor().equals(author)||bookinfos.get(i).getTitle().equals(title)){
				
				tem.add(bookinfos.get(i));
				
				}			
		}
		return tem;
	}

/**
 *@param request
 *@return
 *书籍信息-添加
 */
	@RequestMapping("/add")
	@ResponseBody
	public Integer add(HttpServletRequest request) {
		String code = request.getParameter("code");
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		BookInfo bookinfo = new BookInfo(code, author, title);
		try {
			bookinfoService.addBookInfo(bookinfo);
			return 2;
		} catch (Exception e) {
			return 0;
		}
	}

/**
 *@param request
 *@return
 *书籍信息-更新
 */
	@RequestMapping("/update")
	@ResponseBody
	public Integer update(HttpServletRequest request) {
		String id = request.getParameter("id");
		String code=request.getParameter("code");
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		BookInfo bookinfo = new BookInfo(Integer.parseInt(id), code, author, title);
		try {
			return bookinfoService.updateBookInfo(bookinfo);
		} catch (Exception e) {
			return 0;
		}
	}

/**
 *@param request
 *@return
 *书籍信息-单选删除
 */
	@RequestMapping("/deleteId")
	@ResponseBody
	public Integer delete(HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			BookInfo bookinfo = bookinfoService.selectBookInfoById(Integer.parseInt(id));
			return bookinfoService.deleteBookInfo(bookinfo);
		} catch (Exception e) {
			return 0;
		}
	}

/**
 *@param request
 *@return
 *书籍信息-多选删除
 */
	@RequestMapping("/deleteIds")
	@ResponseBody
	public Integer deleteIds(HttpServletRequest request) {
		try {
			String ids = request.getParameter("ids");
			String[] tempTds = ids.split(",");
			for (String id : tempTds) {
				BookInfo bookinfo = bookinfoService.selectBookInfoById(Integer.parseInt(id));
				bookinfoService.deleteBookInfo(bookinfo);
			}
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
}
