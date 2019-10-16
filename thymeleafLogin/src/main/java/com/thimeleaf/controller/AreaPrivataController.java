package com.thimeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AreaPrivataController {
	//carica AreaPrivata
		@RequestMapping(value = "/areaPrivata", method = RequestMethod.GET)
		public String getHome() {

			return "areaPrivata";
		}
	
}
