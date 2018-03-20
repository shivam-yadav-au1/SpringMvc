package com.wheebox.dao;

import java.util.List;

import com.wheebox.model.DemoQQUser;

public interface UserDetailsDao {

	public List<DemoQQUser> getUserList();
	public void registerUser(String username,String email,String phoneNumber,String address);
	public DemoQQUser getUserById(String id);
	public void  updateUser(DemoQQUser user);
	public void deleteUser(DemoQQUser user);
	public boolean isUserPresent(DemoQQUser user);
	public boolean login(String email,String phonenumber);
	public DemoQQUser getUser(String email,String phonenumber);
	
}
