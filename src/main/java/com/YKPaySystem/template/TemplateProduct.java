package com.YKPaySystem.template;

import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public abstract class TemplateProduct {
		
	public abstract String productBSK(RestTemplate restTemplate, MultiValueMap<String, Object> map) ;
	
	public abstract String productSTR(RestTemplate restTemplate, MultiValueMap<String, Object> map);

	public abstract String productPRB(RestTemplate restTemplate, MultiValueMap<String, Object> map);

}
