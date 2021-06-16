package com.sprinboot.web.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sprinboot.web.springdemo.services.LoginService;
@SessionAttributes("name")
@Controller
public class LoginController {
		@Autowired
	LoginService loginService;


		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public String simpleLogin() {
		return "login";	
	}
			@RequestMapping(value = "/login", method = RequestMethod.POST)
		public String logginControl(@RequestParam String name,@RequestParam String password,ModelMap modelMap) {
        System.out.println(name+  " " + password);	 
        if(loginService.validate(name, password)) {
        modelMap.put("name", name);
        modelMap.put("password",password);
		return "welcome";
        }
        modelMap.put("errorMsg","Invalid Crendital");
        return "login";
         }
	
			
}
