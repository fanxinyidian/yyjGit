package com.yyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyj.dao.ICirculateStateDao;
import com.yyj.model.CirculateState;
import com.yyj.service.ICirculateStateService;

@Service("circulatestateService")
@Transactional
public class CirculateStateService implements ICirculateStateService {

	@Autowired
	private ICirculateStateDao circulatestateDao;
	
	public void addCirculateState(CirculateState circulatestate) {
		// TODO Auto-generated method stub
		circulatestateDao.addCirculateState(circulatestate);

	}

	public CirculateState selectCirculateStateById(int id) {
		// TODO Auto-generated method stub
		return circulatestateDao.selectCirculateStateById(id);
	}

	public List<CirculateState> showByPage(int pageNo, int pageSize) {
		return circulatestateDao.showByPage(pageNo, pageSize);
	}
	
	public int updateCirculateState(CirculateState circulatestate){
		return circulatestateDao.updateCirculateState(circulatestate);
	}

	public int deleteCirculateState(CirculateState circulatestate) {
		// TODO Auto-generated method stub
		return circulatestateDao.deleteCirculateState(circulatestate);
	}

	public int deleteCirculateStates(List<CirculateState> circulatestates) {
		// TODO Auto-generated method stub
		return circulatestateDao.deleteCirculateStates(circulatestates);
	}

}

