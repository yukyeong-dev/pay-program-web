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

import com.YKPaySystem.template.Infomation;
import com.YKPaySystem.util.CookieWork;


@Controller
public class MemberInfoController {
	CookieWork cookieWork = new CookieWork();
	RestTemplate restTemplate = new RestTemplate();
	Infomation templateInfomation = new Infomation();
	
	
	@RequestMapping(value="memberMyInfo")
	public String memberInfo(HttpServletRequest request, Model model) {
		cookieWork.setCookie(request, model);
		
		System.out.println("유저아이이ㅣ디디 : "+cookieWork.getCookieID(request));
		model.addAttribute("userId", cookieWork.getCookieID(request));
		
		return "member/member_infomation";
	}
	
	
	@RequestMapping(value="memberMyInfoOrder")
	public String memberMyInfoOrder(HttpServletRequest request, Model model) throws ParseException {
		
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("userId", cookieWork.getCookieID(request));
		
	//	String result = restTemplate.postForObject("http://localhost:18080/api/memberMyInfoOrder", map, String.class);
		String result = templateInfomation.orderInfo(restTemplate, map);
		
		JSONParser json = new JSONParser();
		Object obj = json.parse(result);
		
		model.addAttribute("member", obj);
		return "member/member_orderInfomation";
	}
	
	
	@RequestMapping(value="memberMyInfoGift")
	public String memberMyInfoGift(HttpServletRequest request, Model model) throws ParseException {

		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("userId", cookieWork.getCookieID(request));
		
//		String result = restTemplate.postForObject("http://localhost:18080/api/memberMyInfoGift", map, String.class);
		String result = templateInfomation.giftInfo(restTemplate, map);
		
		JSONParser json = new JSONParser();
		Object obj = json.parse(result);

		model.addAttribute("member", obj);
		return "member/member_giftInfomation";
	}
	
		

	

}
