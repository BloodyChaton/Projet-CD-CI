package com.wunderit.projetcd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wunderit.projetcd.mongodriver.*;
import org.bson.Document;

import java.util.List;

@Controller
public class LoginController {

    // Create a new instance of MongoDB
	Driver instance = new com.wunderit.projetcd.mongodriver.Driver();
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginMessage(ModelMap model){
		return "login";
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String descriptif){
		model.put("name", name);
		model.put("descriptif", descriptif);

		Document doc = new Document()
		.append("nom", name)
		.append("info", descriptif);

		instance.createdoc(doc);
		
		return "welcome";
	}
}