package com.wheebox.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wheebox.model.StateModel;

@Repository
@Transactional
public class DropDownDaoImpl implements DropDownDao{

	@Autowired SessionFactory session;
	
	@Override
	public List<String> fetchCity(int state_id) {
		String query ="select citi_name from cities where state_id =:id";
		Query q = this.session.getCurrentSession().createSQLQuery(query);
		
		q.setParameter("id", state_id);
		return q.list();
		
		
	}

	@Override
	public List<StateModel> fetchState() {
		Criteria c = this.session.getCurrentSession().createCriteria(StateModel.class);

		return c.list();
		
	}

}
