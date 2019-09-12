package com.thimeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thimeleaf.controller.entità.LoginForm;

@Controller
public class LoginController {
	
	//getHome
	@RequestMapping(value= {"/nuovoSpid","/"}, method=RequestMethod.GET)
 public String getLoginForm() {
	
	return "index"; 
 }
	
	
  //getAreaPrivata
	@RequestMapping(value= "/areaPrivata", method=RequestMethod.GET)
	 public String gethome() {
		
		return "areaPrivata";
	}

	@RequestMapping(value="/controlloLogin",method=RequestMethod.POST) 
		public String login(@ModelAttribute (name="loginForm")LoginForm loginForm, Model model){
			
		String username= loginForm.getUsername();
		String password= loginForm.getPassword();
		
		//mini login
		if("admin".equals(username) && "admin".equals(password)) {
		
		return "areaPrivata"; 
			
		}else {
			model.addAttribute("CredenzialiErrate", true);
			return "login";
		}
		
	}

}