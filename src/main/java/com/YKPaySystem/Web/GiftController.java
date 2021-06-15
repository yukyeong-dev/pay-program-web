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

import com.YKPaySystem.util.CookieWork;

@Controller
public class GiftController {
	CookieWork cookieWork = new CookieWork();
	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(value="productGift")
	public String productGift(HttpServletRequest request, Model model) {
		
		model.addAttribute("totalPoint", request.getParameter("totalPoint"));
		model.addAttribute("productName", request.getParameter("productName"));
		model.addAttribute("productExplain", request.getParameter("productExplain"));
		model.addAttribute("productPrice", request.getParameter("productPrice"));
		model.addAttribute("productCode", request.getParameter("productCode"));
		model.addAttribute("productBarcode", request.getParameter("productBarcode"));
		model.addAttribute("pw", request.getParameter("pw"));		
		
		return "gift/gift_product";
	}
	
	@RequestMapping(value="gift")
	public String gift(HttpServletRequest request, Model model) throws ParseException {
		cookieWork.setCookie(request, model);
		int totalPoint = Integer.parseInt(request.getParameter("totalPoint"));
		int sum = Integer.parseInt(request.getParameter("sum"));
				
		//내 포인트가 부족하면 
		if(totalPoint < sum) {
			int result = sum - totalPoint;
			model.addAttribute("result", result);
			model.addAttribute("totalPoint", totalPoint);
			model.addAttribute("sum", sum);
			return "gift/gift_cancel";
		}		
	
				
		//결제를 할 수 있다면 	
		//parameter 세팅
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("sessionId", cookieWork.getCookieID(request));			//유저 아이디
		map.add("phoneNumber", request.getParameter("phoneNumber"));			//받을 주소
		map.add("totalPoint", request.getParameter("totalPoint"));		//현재 나의 포인트
		map.add("productName", request.getParameter("productName"));	//상품 이름
		map.add("productPrice", request.getParameter("productPrice"));	//상품 가격
		map.add("productCode", request.getParameter("productCode"));	//상품 코드
		map.add("productBarcode", request.getParameter("productBarcode"));	//상품 바코드
		map.add("amount", request.getParameter("amount"));				//수량
		map.add("sum", request.getParameter("sum"));					//총 가격
				
		String result = restTemplate.postForObject("http://localhost:18080/api/gift", map, String.class);
//		String result = templateOrder.order(restTemplate, map);
		
		JSONParser parser = new JSONParser();
		Object object = parser.parse(result);
		System.out.println("=object 들어옴? "+object);
						
		model.addAttribute("map", map);	
		map.add("sessionPw", request.getParameter("pw"));
		return "gift/gift_success";
	}
		

	
	
}
