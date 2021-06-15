package com.YKPaySystem.template;

import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class Charging extends TemplateCharging{

	@Override
	public String charging(RestTemplate restTemplate) {
		return restTemplate.getForObject("http://localhost:18080/api/charging", String.class);	
	}

	@Override
	public int chargingCheck(RestTemplate restTemplate, MultiValueMap<String, Object> map) {
		return restTemplate.postForObject("http://localhost:18080/api/chargingCheck", map, int.class);
	}
	
	

}
