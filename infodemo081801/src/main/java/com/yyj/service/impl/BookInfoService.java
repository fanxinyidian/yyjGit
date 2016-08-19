package com.yyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyj.dao.IBookInfoDao;
import com.yyj.model.BookInfo;
import com.yyj.service.IBookInfoService;

@Service("bookinfoService")
@Transactional
public class BookInfoService implements IBookInfoService {

	@Autowired
	private IBookInfoDao bookinfoDao;
	
	public void addBookInfo(BookInfo bookinfo) {
		// TODO Auto-generated method stub
		bookinfoDao.addBookInfo(bookinfo);

	}

	public BookInfo selectBookInfoById(int id) {
		// TODO Auto-generated method stub
		return bookinfoDao.selectBookInfoById(id);
	}

	public List<BookInfo> showByPage(int pageNo, int pageSize) {
		return bookinfoDao.showByPage(pageNo, pageSize);
	}
	
	public int updateBookInfo(BookInfo bookinfo){
		return bookinfoDao.updateBookInfo(bookinfo);
	}

	public int deleteBookInfo(BookInfo bookinfo) {
		// TODO Auto-generated method stub
		return bookinfoDao.deleteBookInfo(bookinfo);
	}

	public int deleteBookInfos(List<BookInfo> bookinfos) {
		// TODO Auto-generated method stub
		return bookinfoDao.deleteBookInfos(bookinfos);
	}

}

