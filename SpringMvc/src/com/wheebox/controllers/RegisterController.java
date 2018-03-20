package com.wheebox.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wheebox.beans.User;
import com.wheebox.model.DemoQQUser;
import com.wheebox.services.UserDetailsService;

@Controller
public class RegisterController {
	
	
	@Autowired
	UserDetailsService userDetailsService;

	@RequestMapping({"register"}) // url mapping 
	public ModelAndView reg(HttpServletRequest req,HttpServletResponse resp) {

		ModelAndView mv = null;
		String action = req.getParameter("action");
		
		
		
//		System.out.println("Name "+req.getParameter("username")+" Email "+req.getParameter("email")+" PhoneNumber "+req.getParameter("phonenumber")+" Address "+req.getParameter("address")+" Action "+req.getParameter("action"));
		
		if("Register".equals(action)) {
			boolean isValid = validate(req.getParameter("username"),req.getParameter("email"),req.getParameter("phonenumber"),req.getParameter("address"));
			if(isValid) {

//				User user = new User(req.getParameter("username"),req.getParameter("email"),req.getParameter("phonenumber"),req.getParameter("address"));
				DemoQQUser demoUser = new DemoQQUser();
				demoUser.setUsername(req.getParameter("username"));
				demoUser.setEmail(req.getParameter("email"));
				demoUser.setPhoneNumber(req.getParameter("phonenumber"));
				demoUser.setAddress(req.getParameter("address"));
				
				if(!this.userDetailsService.isUserPresent(demoUser)) {
					System.out.println("user is not present in database.");
					this.userDetailsService.registerUser(demoUser.getUsername(), demoUser.getEmail(), demoUser.getPhoneNumber(), demoUser.getAddress());
					req.setAttribute("user", demoUser);
					return 	mv = new ModelAndView("userdetails","isValid",true); // view 
				}
				
				

			}else {
				mv = new ModelAndView("register");
				req.setAttribute("isValid", false);
				putValueInSession(req,resp);
			}
		}
		 mv = new ModelAndView("register"); // view file e.g .jsp
		 return mv;
	}

	private void putValueInSession(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
	
			session.setAttribute("username",req.getParameter("username"));
			req.setAttribute("username", req.getParameter("username"));
			
			session.setAttribute("email",req.getParameter("email"));
			req.setAttribute("email",req.getAttribute("email"));
			
			session.setAttribute("number",req.getParameter("phonenumber"));
			req.setAttribute("number", req.getAttribute("phonenumber"));
			
			session.setAttribute("address",req.getParameter("address"));
			req.setAttribute("address", req.getAttribute("address"));
		
	}

	private boolean validate(String username, String email, String phonenumber,String address) {
		
		
		boolean flag = true;
	
		if("".equals(username.trim()) || "".equals(email.trim()) || "".equals(phonenumber.trim())  || "".equals(address.trim())){
			System.out.println("Second block if ");
			
			flag = false;
		}
		if(phonenumber.length() != 10 && NumberUtils.isNumber(phonenumber)) {
			System.out.println("Phone Number is not valid ");
			flag = false;
		}
		System.out.println("Value of Flag is : "+flag);
		return flag;
	}
}
