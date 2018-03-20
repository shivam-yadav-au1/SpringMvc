package com.wheebox.dao;

import java.util.List;

import com.wheebox.beans.User;
import com.wheebox.model.DemoQQUser;

public class TestingDao {
	
	public static void main(String[] args) {
		
		try {
			UserDetailsDao userDetailsDao = new UserDetailsDaoImpl();
			userDetailsDao.registerUser("Utkarsh", "utkarsh@gmail.com", "7637921235", "Kanpur");
//			List<DemoQQUser> userList =  userDetailsDao.getUserList();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	
		
	}

}
