package com.YKPaySystem.Web;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.YKPaySystem.template.Product;
import com.YKPaySystem.util.CookieWork;

@Controller
public class ProductSTRController {
	CookieWork cookieWork = new CookieWork();
	RestTemplate restTemplate = new RestTemplate(); 
	Product templateProduct = new Product();

	@RequestMapping(value="/product_STR", method={RequestMethod.GET, RequestMethod.POST})
	public String product(HttpServletRequest request,Model model) throws ParseException{
		cookieWork.setCookie(request, model);
		String id= cookieWork.getCookieID(request);
		String pw =cookieWork.getCookiePW(request);
		String name = request.getParameter("name");
		String totalPoint = request.getParameter("totalPoint");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String persent = request.getParameter("persent");
		String productPrice = request.getParameter("productPrice");
		String productCode = request.getParameter("productCode");
		String productOldprice = request.getParameter("productOldprice");
		
		
		// parameter 세팅
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("start", start);
		map.add("end", end);
		map.add("persent", persent);	
		map.add("productPrice",productPrice);
		map.add("productCode", productCode);
		map.add("productOldprice",productOldprice);
		
		
//      String url = "http://localhost:18080/api/productSTR"; 
//		String result = restTemplate.getForObject("http://localhost:18080/api/productSTR", String.class);
		String result = templateProduct.productSTR(restTemplate,map);
		
		JSONParser parser = new JSONParser();
		Object object = parser.parse(result);
	
		model.addAttribute("totalPoint", totalPoint);
		model.addAttribute("product", object);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("name", name);
		return "product_STR_list";
	}
}
