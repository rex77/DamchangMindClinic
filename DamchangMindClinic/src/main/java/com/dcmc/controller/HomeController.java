package com.dcmc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	
	@RequestMapping(value = "/greetings", method = RequestMethod.GET)
	public String greetings(Model model) {
		return "introduction01";
	}
	
	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public String team(Model model) {
		return "introduction02";
	}
	
	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public String map(Model model) {
		return "introduction03";
	}
	
	@RequestMapping(value = "/gallery", method = RequestMethod.GET)
	public String gallery(Model model) {
		return "introduction04";
	}
	
	
	@RequestMapping(value = "/anxiety", method = RequestMethod.GET)
	public String anxiety(Model model) {
		return "adult01";
	}
	
	@RequestMapping(value = "/panic", method = RequestMethod.GET)
	public String panic(Model model) {
		return "adult02";
	}
	
	@RequestMapping(value = "/schizophrenia", method = RequestMethod.GET)
	public String schizophrenia(Model model) {
		return "adult03";
	}
	
	@RequestMapping(value = "/dementia", method = RequestMethod.GET)
	public String dementia(Model model) {
		return "adult04";
	}
	
	@RequestMapping(value = "/insomnia", method = RequestMethod.GET)
	public String insomnia(Model model) {
		return "adult05";
	}
	
	
	@RequestMapping(value = "/adhd", method = RequestMethod.GET)
	public String adhd(Model model) {
		return "child01";
	}
	
	@RequestMapping(value = "/asperger", method = RequestMethod.GET)
	public String asperger(Model model) {
		return "child02";
	}
	
}
