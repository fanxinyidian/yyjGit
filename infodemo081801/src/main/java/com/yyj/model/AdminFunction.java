package com.yyj.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adminfunction")
public class AdminFunction {
	public AdminFunction(){
		
	}
	public AdminFunction(String adminname, int functions){
		this.adminname=adminname;
		this.functions=functions;
	}
	public AdminFunction(int id, String adminname, int functions){
		this.id=id;
		this.adminname=adminname;
		this.functions=functions;
	}
	@Id
	private int id;
	private String adminname;
	private int functions;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	
	public int getFunctions() {
		return functions;
	}
	public void setFunctions(int functions) {
		this.functions = functions;
	}
	@Override
	public String toString() {
		return "AdminFunction [id=" + id + ", adminname=" + adminname
				+ ", functions=" + functions + "]";
	}
	
	
}
