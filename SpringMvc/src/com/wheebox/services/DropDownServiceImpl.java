package com.wheebox.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wheebox.dao.DropDownDao;
import com.wheebox.model.StateModel;

@Service
public class DropDownServiceImpl implements DropDownService{

	@Autowired DropDownDao dropDownDao;
	
	@Override
	public List<String> fetchCity(int id) {
		
		return this.dropDownDao.fetchCity(id);
	}

	@Override
	public List<StateModel> fetchStates() {
		
		return this.dropDownDao.fetchState();
	}

	
}
