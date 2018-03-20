package com.wheebox.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wheebox.services.UserDetailsService;

@Controller
public class LoginController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	
	@RequestMapping({"login"})
	public ModelAndView login(HttpServletRequest req,HttpServletResponse resp) {
		ModelAndView mv = null;
		mv = new ModelAndView("login");
		String action = req.getParameter("action");
		
		
		if("login".equals(action)) {
			
		
			String email = req.getParameter("email");
			String phonenumber = req.getParameter("password");
			boolean isLoginValid = this.userDetailsService.login(email,phonenumber);
			if(isLoginValid) {
				
				mv = new ModelAndView("profile","userProfile",this.userDetailsService.getUser(email, phonenumber));
//				req.setAttribute("message", "Login Successfull");
			}
			else {
				req.setAttribute("message", "Login Failed");
				
			}
		}
		
		return mv; 
	}

}
