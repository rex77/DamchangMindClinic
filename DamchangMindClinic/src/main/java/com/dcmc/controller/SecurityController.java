package com.dcmc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dcmc.service.UserService;

import lombok.extern.log4j.Log4j;


/*
 * 스프링 시큐리티 관련 기능 + 회원 관련 기능을 담당하는 컨트롤러
 */
@Controller
@Log4j
public class SecurityController {
	@Autowired
	UserService us;
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@GetMapping("/login")
	public String login(String error, String logout, Model model) {
		log.info("error: " + error);
		log.info("logout: " + logout);

		if (error != null) {
			model.addAttribute("error", "아이디나 비밀번호가 틀렸습니다");
		}
		if (logout != null) {
			model.addAttribute("logout", "Logout!");
		}
		return "login";
	}
	
	@GetMapping("/signup")
	public void signup(Model model) {
	}

	@PostMapping("/signup")
	public String signupProcess(@RequestParam("id") String id, @RequestParam("password") String password,
			@RequestParam("username") String username, Model model) {
		
		
		us.signup(id, encoder.encode(password), username);
		return "redirect:/login";
	}

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied: " + auth);
		model.addAttribute("msg", "Access Denied");
	}
}
