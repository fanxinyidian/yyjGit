package com.yyj.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yyj.service.IAdminService;
import com.yyj.service.IBookInfoService;
import com.yyj.service.INavService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class TestDao {
	
	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private INavService navService;
	
	@Autowired
	private IBookInfoService bookinfoService;
	@Test
	public void test1(){
//		System.out.println(adminService.selectAdminById(1));
//		System.out.println(navService.selectByNid(0));
//		System.out.println(navService.selectByNidLimitByAuth(0, 1));
		System.out.println(adminService.selectAdminById(4));
	}
	
	@Test
	public void test2(){
		System.out.println(bookinfoService.showByPage(1, 20));
	}
}
