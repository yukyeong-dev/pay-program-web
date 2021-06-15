package com.YKPaySystem.template;

import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class Infomation extends TemplateInfomation{

	@Override
	public String orderInfo(RestTemplate restTemplate, MultiValueMap<String, Object> map) {		
		 String result =restTemplate.postForObject("http://localhost:18080/api/memberMyInfoOrder", map, String.class);
		 System.out.println("결과 들어온???  "+result);
		 return result;
	}

	@Override
	public String giftInfo(RestTemplate restTemplate, MultiValueMap<String, Object> map) {
		return restTemplate.postForObject("http://localhost:18080/api/memberMyInfoGift", map, String.class);
	}
	
}
