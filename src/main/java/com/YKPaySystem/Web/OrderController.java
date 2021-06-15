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

import com.YKPaySystem.template.Order;
import com.YKPaySystem.util.CookieWork;

@Controller
public class OrderController {
	CookieWork cookieWork = new CookieWork();
	RestTemplate restTemplate = new RestTemplate();
	Order templateOrder = new Order();
	
	@RequestMapping(value="productOrder")
	public String productOrder(HttpServletRequest request, Model model) throws ParseException {
		cookieWork.setCookie(request, model);

		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("sessionId", cookieWork.getCookieID(request));
		map.add("productConnect", request.getParameter("productConnect"));
		
		
		//유저가 상품을 구매한적이 있다면 할인율 쓸수있도록 하고, 구매할때 할인된 금액으로 계산되게 해주기
		String user_count = restTemplate.postForObject("http://localhost:18080/api/userCount", map, String.class);	//유저가 구매한적이 있다면
		System.out.println("user_count결과나옴 : "+user_count);
		//user_count결과나옴 : [{"product_price":"9600"},{"product_price":"9600"},{"product_price":"15400"}]
			
		JSONParser parser = new JSONParser();
		Object object = parser.parse(user_count);
		
			
		if(user_count != "") {				//구매한 적이 있다명   -  할인률을 적용해 계산해줘야한다. 
			model.addAttribute("totalPoint", request.getParameter("totalPoint"));
			model.addAttribute("productName", request.getParameter("productName"));
			model.addAttribute("productPrice", request.getParameter("productPrice"));
			model.addAttribute("productCode", request.getParameter("productCode"));
			model.addAttribute("productBarcode", request.getParameter("productBarcode"));
			model.addAttribute("productConnect", request.getParameter("productConnect"));
			model.addAttribute("pw", request.getParameter("pw"));
			model.addAttribute("count", object);
		
			return "order_product";
			
			
		}else {								//구매한 적이 없다면 원가격으로 뜨고

			model.addAttribute("totalPoint", request.getParameter("totalPoint"));
			model.addAttribute("productName", request.getParameter("productName"));
			model.addAttribute("productPrice", request.getParameter("productPrice"));
			model.addAttribute("productCode", request.getParameter("productCode"));
			model.addAttribute("productBarcode", request.getParameter("productBarcode"));
			model.addAttribute("productConnect", request.getParameter("productConnect"));
			model.addAttribute("pw", request.getParameter("pw"));
			return "order_product";
		}
			
	}
	
	@RequestMapping(value="order")
	public String order(HttpServletRequest request, Model model) throws ParseException {
		cookieWork.setCookie(request, model);

		int totalPoint = Integer.parseInt(request.getParameter("totalPoint"));
		int sum = Integer.parseInt(request.getParameter("sum"));
	
		//내 포인트가 부족하면 
		if(totalPoint < sum) {
			int result = sum - totalPoint;
			model.addAttribute("result", result);
			model.addAttribute("totalPoint", totalPoint);
			model.addAttribute("sum", sum);
			return "order_cancel";
		}		
		
		//결제를 할 수 있다면 	
		
		//할인률과 상품가격 가져와서 퍼센트 계산해주고 밑에서 update해주기 - 이거 계산을 api쪽에서 해주기로하자
		
		
		
		
		//parameter 세팅
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("sessionId", cookieWork.getCookieID(request));				//유저 아이디
		map.add("address", request.getParameter("address"));				//받을 주소
		map.add("totalPoint", request.getParameter("totalPoint"));			//현재 나의 포인트
		map.add("productName", request.getParameter("productName"));		//상품 이름
		map.add("productPrice", request.getParameter("productPrice"));		//상품 가격
		map.add("productCode", request.getParameter("productCode"));		//상품 코드
		map.add("productBarcode", request.getParameter("productBarcode"));	//상품 바코드
		map.add("amount", request.getParameter("amount"));					//수량
		map.add("sum", request.getParameter("sum"));						//총 가격
		map.add("apply", request.getParameter("apply"));					//할인률
		map.add("productConnect", request.getParameter("productConnect"));	//상점코드
		
//		String result = restTemplate.postForObject("http://localhost:18080/api/order", map, String.class);
		String result = templateOrder.order(restTemplate, map);
		
		JSONParser parser = new JSONParser();
		Object object = parser.parse(result);
		System.out.println("=object 들어옴? "+object);
				
		model.addAttribute("map", map);
		map.add("sessionPw", cookieWork.getCookiePW(request));
		return "order_sucess";
	}
}
