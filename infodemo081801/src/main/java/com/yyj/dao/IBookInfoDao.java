package com.yyj.dao;

import java.util.List;

import com.yyj.model.BookInfo;

public interface IBookInfoDao {
	
	public void addBookInfo(BookInfo bookinfo);
	
	public int updateBookInfo(BookInfo bookinfo);
	
	public int deleteBookInfo(BookInfo bookinfo);
	
	public int deleteBookInfos(List<BookInfo> bookinfos);
	
	public BookInfo selectBookInfoById(int id);
	
	public List<BookInfo> showByPage(int pageNo,int pageSize);
	

}

