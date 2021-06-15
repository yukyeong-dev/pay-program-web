package com.YKPaySystem.template;

import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class Order extends TemplateOrder{

	@Override
	public String order(RestTemplate restTemplate,  MultiValueMap<String, Object> map) {
		return restTemplate.postForObject("http://localhost:18080/api/order", map, String.class);
	}

}
