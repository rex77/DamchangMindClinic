package com.dcmc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcmc.domain.Criteria;
import com.dcmc.domain.PageDTO;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/admin/*")
public class AdminController {

	@GetMapping("/sample") 
	public String getSample(Criteria cri, Model model) {
		return "admin_sample";
	}
}
