package com.YKPaySystem.Web;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.YKPaySystem.template.Charging;
import com.YKPaySystem.util.CookieWork;

@Controller
public class ChargingContoller {
	CookieWork cookieWork = new CookieWork();
	RestTemplate restTemplate = new RestTemplate();
	Charging templateCharging = new Charging();
	
	//충전하기를 눌렀을 때
	@RequestMapping(value="Charging")
	public String charging(HttpServletRequest request, Model model) throws ParseException {
		cookieWork.setCookie(request, model);
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
				
		//api에서 로그인 정보 가져오기
//		String result = restTemplate.getForObject("http://localhost:18080/api/charging", String.class);
		
		String result = templateCharging.charging(restTemplate);
		JSONParser json = new JSONParser();
		Object obj = json.parse(result);

		model.addAttribute("userId", userId);
		model.addAttribute("userPw", userPw);
		model.addAttribute("charging", obj);
		return "/charging/myCharging";
	}
	
	
	//충전할 포인트를  api한테 넘겨주고 api는 충전해주기
	@RequestMapping(value="ChargingCheck")
	public String chargingCheck(HttpServletRequest request, Model model) throws ParseException {
		cookieWork.setCookie(request, model);
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");				
	
		String chargingPoint = request.getParameter("chargingPoint");
		String sessionId = cookieWork.getCookieID(request);		
		System.out.println("==sessionId====="+sessionId);
		
		// parameter 세팅
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("chargingPoint", chargingPoint);
		map.add("sessionId", sessionId);
		
		
		// post
//		int result = restTemplate.postForObject("http://localhost:18080/api/chargingCheck", map, int.class);	
		int result = templateCharging.chargingCheck(restTemplate, map);
		
		if(result > 0) {
//			String result2 = restTemplate.getForObject("http://localhost:18080/api/charging", String.class);
			String result2 = templateCharging.charging(restTemplate);
			JSONParser json2 = new JSONParser();
			Object obj2 = json2.parse(result2);
			
			model.addAttribute("result", result);
			model.addAttribute("userId", userId);
			model.addAttribute("userPw", userPw);
			model.addAttribute("charging", obj2);			
			return "/charging/myChargingResult";
		}
		return "product";

	}
	
	
	
	
	
}
