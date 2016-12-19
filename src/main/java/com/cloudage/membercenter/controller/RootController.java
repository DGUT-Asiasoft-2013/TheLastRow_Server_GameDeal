package com.cloudage.membercenter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cloudage.membercenter.service.IAdminService;

@Controller
@RequestMapping("/")
public class RootController {
	@Autowired
	IAdminService adminService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model,HttpServletRequest request){
		return "redirect:/staff";
	}
	
	@RequestMapping("/staff")
	public String staff(ModelMap model){
		return "staff";
	}
	
	
	
	@RequestMapping("/users")
	public String users(ModelMap model){
		return "users";
	}
	
	@RequestMapping("/feeds")
	public String feeds(){
		return "feeds";
	}
	
	@RequestMapping("/test")
    public @ResponseBody String testSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("c");
        int s = 0;
        if(obj instanceof Integer){
        	s = (int)obj;
        }
        
        s += 1;
        session.setAttribute("c", s);
        return String.valueOf(s);
    }
}
