package com.wheebox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="states")
public class StateModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="state_id")
	private int id;
	@Column(name="state_name")
	private String stateName;
	

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	
}
