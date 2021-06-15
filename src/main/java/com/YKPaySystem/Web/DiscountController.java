package com.YKPaySystem.Web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.YKPaySystem.util.CookieWork;

@Controller
public class DiscountController {
	CookieWork cookieWork = new CookieWork();
	RestTemplate restTemplate = new RestTemplate(); 
	
	//세일기간 설정페이지로 들어갈때 가져가야할 것-
	@RequestMapping(value="/discount")
	public String discount(HttpServletRequest request, Model model) {
		cookieWork.setCookie(request, model);
		
		model.addAttribute("productPrice", request.getParameter("productPrice"));
		model.addAttribute("productCode", request.getParameter("productCode"));
		model.addAttribute("productOldprice", request.getParameter("productOldprice"));
		model.addAttribute("id", cookieWork.getCookieID(request));
		model.addAttribute("pw", cookieWork.getCookiePW(request));
		return "/discount/discount_set";
	}
	
	
	@RequestMapping(value="/discountSet")
	public String discountSet(HttpServletRequest request, Model model) {
		cookieWork.setCookie(request, model);
		//여기선 테이블에 업데이트 해주기//
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String persent = request.getParameter("persent");		
		String productCode = request.getParameter("productCode");
		String productPrice = request.getParameter("productPrice");
		String productOldprice = request.getParameter("productOldprice");
		
		// parameter 세팅
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("start", start);
		map.add("end", end);
		map.add("persent", persent);
		map.add("productCode", productCode);
		map.add("productOldprice", productOldprice);
		
		int result = restTemplate.postForObject("http://localhost:18080/api/discount", map, int.class);
//		update productprbsale_table set sale_start="2019-04-19", sale_end="2019-04-20", sale_rate="10" where product_code="PRB0001"
//		System.out.println("업데이트 결과가 나왔나? "+result);
			
		if(result > 0 ) {
			model.addAttribute("start", start);
			model.addAttribute("end", end);
			model.addAttribute("persent", persent);
			model.addAttribute("productCode", productCode);
			model.addAttribute("sessionId", cookieWork.getCookieID(request));
			model.addAttribute("sessionPw", cookieWork.getCookiePW(request));
			model.addAttribute("productPrice", productPrice);
			model.addAttribute("productOldprice", productOldprice);
			
			return "/discount/discount_sucess";
			
		}else {
			return "/duscount/discount_cancel";
		}
//		double percentage = Integer.parseInt(persent) * 0.01; 				//할인율
//	    double yourmoney = Integer.parseInt(productPrice) * percentage; 	//할인받는 금액
//	    double actually = Integer.parseInt(productPrice) - yourmoney; 		//최종지불 금액
	
	}

}
