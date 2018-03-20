package com.wheebox.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wheebox.model.DemoQQUser;
import com.wheebox.services.DropDownService;

@Controller
public class DropdownController {

	@Autowired DropDownService dropDownService;
	
	@RequestMapping({"dropDown"})
	public ModelAndView dropDown() {
		System.out.println("Controll camed in DropDownController ....");
		ModelAndView mv = new ModelAndView("dropdown","dropDownList",this.dropDownService.fetchStates());
		return mv;
	}

	
/*	@RequestMapping(value= {"cities?value="},method=RequestMethod.GET)
	public @ResponseBody List<DemoQQUser> getUserList(){
//		return this.userDetailsService.getUserList();
	}*/
	
	
	@RequestMapping({"city"})
	public ModelAndView getCity(final HttpServletRequest req,final HttpServletResponse resp) {
		
		ModelAndView modelAndView = null;
		String stateId = req.getParameter("state_id");
		System.out.println("Value of State : "+stateId);
		List<String> cityList = new ArrayList<String>();
		cityList = this.dropDownService.fetchCity(Integer.parseInt(stateId));
		System.out.println("Size of city List :"+cityList.size());
		for(String city:cityList) {
			System.out.println(city);
		}
		modelAndView = new ModelAndView("dropdown","cityList",cityList);
		
		return modelAndView;
	}
	
	
	
}
