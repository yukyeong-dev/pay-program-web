package com.YKPaySystem.template;

import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public abstract class TemplateCharging {
	
	abstract String charging(RestTemplate restTemplate);
	abstract int chargingCheck(RestTemplate restTemplate, MultiValueMap<String, Object> map);
}
