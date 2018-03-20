package com.wheebox.services;

import java.util.List;

import com.wheebox.model.DemoQQUser;

public interface UserDetailsService {
	
	public void registerUser(final String username,final String email,final String phoneNumber,final String address);
	public List<DemoQQUser> getUserList();
	public DemoQQUser getUserById(String id);
	public void updateUser(DemoQQUser user);
	public void deleteUser(DemoQQUser user);
	public boolean isUserPresent(DemoQQUser user);
	public boolean login(String email,String phonenumber);
	public DemoQQUser getUser(String email,String phonenumber);
}
