package com.YKPaySystem.template;

import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public abstract class TemplateOrder {
	
	abstract String order(RestTemplate restTemplate,  MultiValueMap<String, Object> map);

}
