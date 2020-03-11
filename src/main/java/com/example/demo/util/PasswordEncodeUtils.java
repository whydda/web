package com.example.demo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncodeUtils {

	public static String encodePassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}

	public static boolean matchesPassword(String paramPassword, String dbPassword) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(paramPassword, dbPassword);
	}
}
