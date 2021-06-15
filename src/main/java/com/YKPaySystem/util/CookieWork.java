package com.YKPaySystem.util;

import java.io.*;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class CookieWork {
	public String getCookieID(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies(); 
		String sessionID="";
		if(cookies != null) { 
			for(int i = 0 ; i<cookies.length; i++){  
				try {
					System.out.println(i + "번째 쿠키에 설정된 값 : " + URLDecoder.decode(cookies[i].getValue(),"UTF-8"));
					sessionID = URLDecoder.decode(cookies[2].getValue(),"UTF-8");
				} catch (UnsupportedEncodingException e) {
				}	
			}		
		}
		return sessionID;
	}	
	public String getCookiePW(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies(); 
		String sessionPW="";
		if(cookies != null) { 
			for(int i = 0 ; i<cookies.length; i++){  
				try {
					System.out.println(i + "번째 쿠키에 설정된 값 : " + URLDecoder.decode(cookies[i].getValue(),"UTF-8"));
					sessionPW = URLDecoder.decode(cookies[0].getValue(),"UTF-8");
				} catch (UnsupportedEncodingException e) {
				}	
			}		
		}
		return sessionPW;
	}
	
	
	public void setCookie(HttpServletRequest req, Model model) {
		String sessionID="";
		String sessionNAME="";
		String sessionPW="";
		Cookie[] cookies = req.getCookies();            // 요청정보로부터 쿠키를 가져온다.
		
		if(cookies != null) {
			for(int i = 0 ; i<cookies.length; i++){                            // 쿠키 배열을 반복문으로 돌린다.
				
				if(cookies[i].getName().equals("loginID")) {
					try {
//						System.out.println(i + "번째 쿠키에 설정된 값 : " + URLDecoder.decode(cookies[i].getValue(),"UTF-8"));
						sessionID = URLDecoder.decode(cookies[i].getValue(),"UTF-8");
					} catch (UnsupportedEncodingException e) {
					}
				}
				if(cookies[i].getName().equals("loginNAME")) {
					try {
//						System.out.println(i + "번째 쿠키에 설정된 값 : " + URLDecoder.decode(cookies[i].getValue(),"UTF-8"));
						sessionNAME = URLDecoder.decode(cookies[i].getValue(),"UTF-8");
					} catch (UnsupportedEncodingException e) {
					}
				}	
				if(cookies[i].getName().equals("loginPW")) {
					try {
//						System.out.println(i + "번째 쿠키에 설정된 값 : " + URLDecoder.decode(cookies[i].getValue(),"UTF-8"));
						sessionPW = URLDecoder.decode(cookies[i].getValue(),"UTF-8");
					} catch (UnsupportedEncodingException e) {
					}
				}
			}
		}
	    model.addAttribute("sessionID",sessionID);
	    model.addAttribute("sessionNAME",sessionNAME);
	    model.addAttribute("sessionPW",sessionPW);
	}
}
