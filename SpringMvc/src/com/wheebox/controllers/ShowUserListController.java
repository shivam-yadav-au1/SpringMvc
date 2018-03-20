package com.wheebox.controllers;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/*import com.sun.java.util.jar.pack.Package.Class.Method;*/
import com.wheebox.model.DemoQQUser;
import com.wheebox.services.UserDetailsService;

@Controller
public class ShowUserListController {

	@Autowired
	UserDetailsService userDetailsService;

	@RequestMapping({ "showlist" })
	public ModelAndView showUserList(HttpServletRequest req,HttpServletResponse resp) {

		ModelAndView mv = new ModelAndView("userlist", "userList", this.userDetailsService.getUserList());

		String action = req.getParameter("action");
		if ("Delete".equals(action)) {

			System.out.println("Delete block executed ...");

			DemoQQUser user = new DemoQQUser();
			user.setId(Integer.parseInt(req.getParameter("id")));
			user.setUsername(req.getParameter("username"));
			user.setEmail(req.getParameter("email"));
			user.setPhoneNumber(req.getParameter("phonenumber"));
			user.setAddress(req.getParameter("address"));
			this.userDetailsService.deleteUser(user);
			mv = new ModelAndView("userlist", "userList", this.userDetailsService.getUserList());
		
		}
		return mv;
	}
	
	@RequestMapping(value= {"/webservice/userlist"},method=RequestMethod.GET)
	public @ResponseBody List<DemoQQUser> getUserList(){
		return this.userDetailsService.getUserList();
	}

	@RequestMapping({ "update" })
	public ModelAndView updateUser(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = null;
		
		String action = req.getParameter("action");
	
		DemoQQUser user = this.userDetailsService.getUserById(req.getParameter("id"));
		mv = new ModelAndView("update","user",user);
		
		if("Update".equals(action)) {
		
			DemoQQUser updateUser = new DemoQQUser();
			updateUser.setId(Integer.parseInt(req.getParameter("id")));
			updateUser.setUsername(req.getParameter("username"));
			updateUser.setEmail(req.getParameter("email"));
			updateUser.setPhoneNumber(req.getParameter("phonenumber"));
			updateUser.setAddress(req.getParameter("address"));
			this.userDetailsService.updateUser(updateUser);
			mv = new ModelAndView("userlist","userList",this.userDetailsService.getUserList());
		/*	int result = this.userDetailsService.updateUser(updateUser);
			if(result > 0) {
				req.setAttribute("status", "Success");
				mv =new  ModelAndView("userlist","userList",this.userDetailsService.getUserList());
			}
			else {
				req.setAttribute("status", "Failed");
			}*/
			

//			mv = new ModelAndView("update","result",result);
		}
		return mv;
	}
}
