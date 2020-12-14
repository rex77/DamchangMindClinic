package com.dcmc.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

/*
 * 오직 리다이렉트만을 위한 로그인성공핸ㄴ들러
 */
@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.sendRedirect("/admin/notice/list");
	}
	
}
