package com.marcossa.api.apirestproject.service;

import org.springframework.security.core.context.SecurityContextHolder;

import com.marcossa.api.apirestproject.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} 
		catch (Exception e) {
			return null;
		}
	}

}
