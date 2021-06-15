package com.YKPaySystem.template;

import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class Login extends TemplateLogin{
	
	//post
	@Override
	public String loginStart(RestTemplate restTemplate, MultiValueMap<String, Object> map) {
		String result = restTemplate.postForObject("http://localhost:18080/api/login", map, String.class);
		System.out.println("result ====="+result);
		return result;
	}
	
	@Override
	public String loginPoint(RestTemplate restTemplate) {
		return restTemplate.getForObject("http://localhost:18080/api/charging", String.class);		
	}

	
	

}
