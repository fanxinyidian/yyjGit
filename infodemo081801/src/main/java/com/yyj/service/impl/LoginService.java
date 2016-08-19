package com.yyj.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyj.dao.IBookInfoDao;
import com.yyj.dao.ILoginDao;
import com.yyj.dao.impl.LoginDao;
import com.yyj.model.Admin;
import com.yyj.service.ILoginService;
@Service("loginService")
@Transactional
public class LoginService implements ILoginService {
	@Autowired
	private ILoginDao loginDao;
	public int check(String name,String password) {
		return loginDao.check(name,password);
		
	}

}
