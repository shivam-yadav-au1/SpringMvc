package com.wheebox.services;

import java.util.List;

import com.wheebox.model.StateModel;

public interface DropDownService {

	public List<String> fetchCity(int id);
	public List<StateModel> fetchStates();
}
