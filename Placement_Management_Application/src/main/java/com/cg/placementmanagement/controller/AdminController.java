package com.cg.placementmanagement.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.placementmanagement.model.Admin;
import  com.cg.placementmanagement.service.AdminService;



@Controller
public class AdminController {
	
	@Autowired
    private AdminService userService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView mainpage() {
    	ModelAndView mav = new ModelAndView("adminlogin");
        mav.addObject("user", new Admin());
        return mav;
    }
                                   
    @RequestMapping(path = "/adminlogin", method = RequestMethod.GET)
    public ModelAndView login() {
    	ModelAndView mav = new ModelAndView("adminlogin");
        mav.addObject("user", new Admin());
        return mav;
    }

    @PostMapping("/adminlogin")
    public String login(@ModelAttribute("user") Admin user ) {
    	
    	Admin oauthUser = userService.login(user.getUsername(), user.getPassword());
    	

    	System.out.print(oauthUser);
    	if(Objects.nonNull(oauthUser)) 
    	{	
  
    		return "redirect:/adminindex";
    	
    		
    	} else {
    		return "redirect:/adminlogin";
    		
    	
    	}

}
    
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
    	 
        return "redirect:/adminlogin";
    }
}