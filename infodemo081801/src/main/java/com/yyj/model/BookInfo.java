package com.yyj.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProperty;
import org.directwebremoting.annotations.RemoteProxy;

@Entity
@Table(name ="bookinfo")
@DataTransferObject
public class BookInfo {

	public BookInfo() {
	}
	
	public BookInfo(String code, String author, String title) {
		this.code=code;
		this.author =author;
		this.title =title;
		
	}
	public BookInfo(int id,String code, String author, String title) {
		
		this.id = id;
		this.code=code;
		this.author = author;
		this.title = title;
		
	}

	@Id
	private int id;
	private String author;
	private String title;
	private String code;
	
	@RemoteProperty
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	@RemoteProperty
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	@RemoteProperty
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	@RemoteProperty
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "BookInfo [id=" + id + ", author=" + author + ", title=" + title
				+ ", code=" + code + "]";
	}
	
}
