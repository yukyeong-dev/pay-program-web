package com.YKPaySystem.template;

import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public abstract class TemplateLogin {
	
	//로그인시 아이디 비번 확인
	abstract String loginStart(RestTemplate restTemplate, MultiValueMap<String, Object> map);
	
	//로그인 시 포인트 확인
	abstract String loginPoint(RestTemplate restTemplate);
}
