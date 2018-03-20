package com.wheebox.dao;

import java.util.List;

import com.wheebox.model.StateModel;

public interface DropDownDao {

	public List<StateModel> fetchState();
	public List<String> fetchCity(int id);
	
}
