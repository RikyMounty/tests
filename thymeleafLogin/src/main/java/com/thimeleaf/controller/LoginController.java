package com.thimeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thimeleaf.controller.entità.LoginForm;

@Controller
public class LoginController {
	@RequestMapping(value="/nuovoSpid", method=RequestMethod.GET)
 public String getLoginForm() {
	
	 //nome pagina
	return "login";
	 
 }
  
	//mini controllo
	@RequestMapping(value="/nuovoSpid",method=RequestMethod.POST) 
		public String login(@ModelAttribute (name="loginForm")LoginForm loginForm, Model model){
			
		String username= loginForm.getUsername();
		String password= loginForm.getPassword();
		
		if("admin".equals(username) && "admin".equals(password)) {
		
		return "home";
			
		}else {
			model.addAttribute("CredenzialiErrate", true);
			return "login";
		}
		
	}

}