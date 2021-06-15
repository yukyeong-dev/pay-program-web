package com.YKPaySystem.template;

import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class Product extends TemplateProduct{

	@Override
	public String productPRB(RestTemplate restTemplate, MultiValueMap<String, Object> map) {
		return restTemplate.postForObject("http://localhost:18080/api/productPRB", map,String.class);
	}

	@Override
	public String productBSK(RestTemplate restTemplate, MultiValueMap<String, Object> map) {
		return restTemplate.postForObject("http://localhost:18080/api/productBSK",map, String.class);
	}

	@Override
	public	String productSTR(RestTemplate restTemplate, MultiValueMap<String, Object> map) {
		return restTemplate.postForObject("http://localhost:18080/api/productSTR",map, String.class);
	}

		

}
