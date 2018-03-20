package com.wheebox.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wheebox.model.DemoQQUser;

@Repository
@Transactional
public class UserDetailsDaoImpl implements UserDetailsDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<DemoQQUser> getUserList() {

		Criteria c = sessionFactory.getCurrentSession().createCriteria(DemoQQUser.class);
		List<DemoQQUser> dm = c.list();

		return dm;
	}

	@Override
	public void registerUser(String username, String email, String phoneNumber, String address) {
		// System.out.println(getClass()+" got executed ...");

		try {
			DemoQQUser user = new DemoQQUser();
			user.setUsername(username);
			user.setEmail(email);
			user.setPhoneNumber(phoneNumber);
			user.setAddress(address);

			this.sessionFactory.getCurrentSession().save(user);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}

	}

	@Override
	public DemoQQUser getUserById(String id) {

		Criteria c = sessionFactory.getCurrentSession().createCriteria(DemoQQUser.class)
				.add(Restrictions.eq("id", Integer.parseInt(id)));
		DemoQQUser user = (DemoQQUser) c.uniqueResult();
		System.out.println(user);
		return user;

	}

/*	@Override
	public int updateUser(DemoQQUser user) {
		String query = "update DemoQQUser  set username =:username, email = :email, phoneNumber = :phoneNumber, address = :address "
				+ "where id = :id";
		Query q = sessionFactory.getCurrentSession().createQuery(query);
		q.setParameter("id", user.getId());
		q.setParameter("username",user.getUsername());
		q.setParameter("email", user.getEmail());
		q.setParameter("phoneNumber", user.getPhoneNumber());
		q.setParameter("address", user.getAddress());
		int result = q.executeUpdate();
		return result;
	}*/
	

	
	

	@Override
	public void deleteUser(DemoQQUser user) {
		String query = "delete from DemoQQUser  where id=:id";
		
		Query q = sessionFactory.getCurrentSession().createQuery(query);
		q.setParameter("id", user.getId());
	
		
		int result = q.executeUpdate();
		
	}

	@Override
	public void updateUser(DemoQQUser user) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		
	}

	@Override
	public boolean isUserPresent(DemoQQUser user) {
		
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(DemoQQUser.class)
				.add(Restrictions.eq("phoneNumber", user.getPhoneNumber()))
				.add(Restrictions.eq("email", user.getEmail()));
		List<DemoQQUser> userList = c.list();
		
		if(userList.size() > 0) {
		
			return true;
		}else{
			
			return false;
		}
		
		
	}
	
	@Override
	public DemoQQUser getUser(String email,String phonenumber) {
		
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(DemoQQUser.class)
			.add(Restrictions.eq("email", email))
			.add(Restrictions.eq("phoneNumber", phonenumber));
		DemoQQUser user = (DemoQQUser) c.uniqueResult();
		return user;
	}

	@Override
	public boolean login(String email, String phonenumber) {
		boolean isLogin = false;
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(DemoQQUser.class)
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("phoneNumber", phonenumber));
		List<DemoQQUser> userList = c.list();
		
		if(userList.size() == 1) {
			isLogin = true;
		}
		else {
			isLogin = false;
		}
		return isLogin;
	}

}
