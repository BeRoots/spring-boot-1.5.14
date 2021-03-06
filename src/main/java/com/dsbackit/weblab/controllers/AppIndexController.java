package com.dsbackit.weblab.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppIndexController {
	/**
	 * Home action
	 * @return String
	 */
	@GetMapping(value = {"/index", "", "/", "/home"})
	public String home() {
		return "app-view-index";
	}
	/**
	 * Localize action
	 * @return void
	 */
	@GetMapping("/localize/{lang}")
	public void localize(@PathVariable String lang, HttpServletResponse httpResponse) throws Exception {
	    Pattern pattern = Pattern.compile("[a-z]{2}_[A-Z]{2}");
	    Matcher matcher = pattern.matcher(lang);
	    if(matcher.find()) {
	        httpResponse.sendRedirect("/home?lang=" + lang);
	    }
	    else {
			throw new Exception("Bad PathVariable lang.");	    	
	    }
	}
}