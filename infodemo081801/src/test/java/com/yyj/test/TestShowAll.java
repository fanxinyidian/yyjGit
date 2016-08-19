package com.yyj.test;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.yyj.model.*;
import com.yyj.controller.*;
public class TestShowAll {
			public static void main(String[] args){
				//TestShowAll test=new TestShowAll();
				/*ApplicationContext con=new  ClassPathXmlApplicationContext("pring-hibernate2.xml");
				JdbcTemplate jt=(JdbcTemplate) con.getBean("jdbcTemplate");
				//String sql="insert into admin values (?,?,?,?)";
				//jt.execute(sql);
				String sql="select * from admin";
				List<Admin> lst=jt.queryForList(sql, Admin.class);
				//AdminController ac=new AdminController();
				//ac.showAll1();
				System.out.println(lst.size());
				System.out.println("h");*/
				//AdminController ac=new AdminController();
				
				//System.out.println(ac.showAll().size());
				String s="123";
				int a=Integer.parseInt(s);
				System.out.println(a);
			}
}
