package com.wheebox.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wheebox.dao.UserDetailsDao;
import com.wheebox.model.DemoQQUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserDetailsDao userDetailsDao;

	@Override
	public void registerUser(String username, String email, String phoneNumber, String address) {
		this.userDetailsDao.registerUser( username, email, phoneNumber, address);
		
	}

	@Override
	public List<DemoQQUser> getUserList() {

		List<DemoQQUser> userList = this.userDetailsDao.getUserList();
		return  userList;
	}

	@Override
	public DemoQQUser getUserById(String id) {
		return this.userDetailsDao.getUserById(id);
		
	}

/*	@Override
	public int updateUser(DemoQQUser user) {
		int result = this.userDetailsDao.updateUser(user);
		return result;
	}*/
	
	

	@Override
	public void deleteUser(DemoQQUser user) {
		this.userDetailsDao.deleteUser(user);
		
		
	}

	@Override
	public void updateUser(DemoQQUser user) {
		
		this.userDetailsDao.updateUser(user);
		
	}

	@Override
	public boolean isUserPresent(DemoQQUser user) {
	
		return this.userDetailsDao.isUserPresent(user);
	}

	@Override
	public boolean login(String email, String phonenumber) {
		
		return this.userDetailsDao.login(email,phonenumber);
	}

	@Override
	public DemoQQUser getUser(String email, String phonenumber) {
	
		return this.userDetailsDao.getUser(email, phonenumber);
	}

}
