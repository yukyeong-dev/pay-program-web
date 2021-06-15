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
public class ProductPRBController {
	CookieWork cookieWork = new CookieWork();
	RestTemplate restTemplate = new RestTemplate(); 
	Product templateProduct = new Product();
		
	
	//상품리스트 뿌려주기
	@RequestMapping(value="/product_PRB", method={RequestMethod.GET, RequestMethod.POST})
	public String product(HttpServletRequest request, Model model) throws ParseException, java.text.ParseException{
		cookieWork.setCookie(request, model);	
		String id= cookieWork.getCookieID(request);	//xodbrud
		String pw =cookieWork.getCookiePW(request);	//dbrud
		String totalPoint = request.getParameter("totalPoint");
		String name = request.getParameter("name");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String persent = request.getParameter("persent");
		String productPrice = request.getParameter("productPrice");
		String productCode = request.getParameter("productCode");
		String productOldprice = request.getParameter("productOldprice");
		//상품코드 string으로 받아서 where절에 뿌려줘서 찾는다.//
		
		// parameter 세팅
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("start", start);
		map.add("end", end);
		map.add("persent", persent);	
		map.add("productPrice",productPrice);
		map.add("productCode", productCode);
		map.add("productOldprice",productOldprice);
			
//		String result = restTemplate.getForObject("http://localhost:18080/api/productPRB", String.class);
		String result = templateProduct.productPRB(restTemplate,map);
			
		JSONParser parser = new JSONParser();
		
		Object object = parser.parse(result);
System.out.println("object들어왔습니다~  "+object);
//[{"saleRate":20,"productCode":"PRB0001","saleEnd":"2019-04-20","saleStart":"2019-04-18","productImgUrl":"https:\/\/www.paris.co.kr\/data\/product\/[1]%EB%A1%9C%EB%A7%9D%EC%8A%A4.jpg","productExplain":"SMALL_CAKE","productBarcode":"82821912","productName":"초코케이크","productPrice":12000}
		
		model.addAttribute("totalPoint", totalPoint);
		model.addAttribute("product", object);
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		model.addAttribute("pw", pw);
		return "product_PRB_list";
	}
}
