package com.YKPaySystem.template;

import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public abstract class TemplateInfomation {
	
	abstract String orderInfo(RestTemplate restTemplate, MultiValueMap<String, Object> map);
	
	abstract String giftInfo(RestTemplate restTemplate, MultiValueMap<String, Object> map);
}
