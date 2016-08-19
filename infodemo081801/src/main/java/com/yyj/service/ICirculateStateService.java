package com.yyj.service;

import java.util.List;

import com.yyj.model.CirculateState;;

public interface ICirculateStateService {

	public void addCirculateState(CirculateState circulatestate);

	public int updateCirculateState(CirculateState circulatestate);

	public int deleteCirculateState(CirculateState circulatestate);

	public int deleteCirculateStates(List<CirculateState> circulatestates);

	public CirculateState selectCirculateStateById(int id);

	public List<CirculateState> showByPage(int pageNo, int pageSize);

}
