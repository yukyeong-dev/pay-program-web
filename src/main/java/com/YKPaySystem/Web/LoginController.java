package com.YKPaySystem.Web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


import com.YKPaySystem.template.Login;
import com.YKPaySystem.util.CookieWork;

@Controller
public class LoginController {
	CookieWork cookieWork = new CookieWork();
	Login templateLogin = new Login();
	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(value="login")
	public String login(HttpServletRequest request, Model model) {
		return "login";
	}
	
	
	@RequestMapping(value="main")
	public String main(HttpServletRequest request, Model model) {
		return "main";
	}
	
		
	@RequestMapping(value="loginCheck")
	public String Check(HttpServletRequest request, Model model, HttpServletResponse response) throws ParseException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String persent = request.getParameter("persent");	
		String productPrice = request.getParameter("productPrice");
		String productCode = request.getParameter("productCode");
		String productOldprice = request.getParameter("productOldprice");
		
		// parameter 세팅
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("userId", userId);
		map.add("userPw", userPw);
		
		String result = templateLogin.loginStart(restTemplate, map);
		//String result = restTemplate.postForObject("http://localhost:18080/api/login", map, String.class);		
		JSONParser json = new JSONParser();
		Object obj = json.parse(result);

		if(result.equals("[]")) {
			System.out.println("아이디없음");
			model.addAttribute("msg"," ID나 비밀번호가 옳바르지 않습니다.");			
			model.addAttribute("url", "login");
			return "view_messagePage";			
			
		}else {
			Cookie cookie1 = new Cookie("loginID",userId);
			Cookie cookie2 = new Cookie("loginPW",userPw);
			cookie1.setMaxAge(60*30); // 기간을 30분 설정
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
			model.addAttribute("idd", cookie1.getValue());
			model.addAttribute("pww", cookie2.getValue());			
			
		//	String result2 = restTemplate.getForObject("http://localhost:18080/api/charging", String.class);
			String result2 = templateLogin.loginPoint(restTemplate);
		
			JSONParser json2 = new JSONParser();
			Object obj2 = json2.parse(result2);
			
			
			System.out.println("11시작일"+start);
			System.out.println("11종료일"+end);
			System.out.println("11퍼센트"+persent);
			model.addAttribute("charging", obj2);			
			model.addAttribute("member", obj);
			model.addAttribute("start", start);
			model.addAttribute("end", end);
			model.addAttribute("persent", persent);
			model.addAttribute("productPrice", productPrice);
			model.addAttribute("productCode", productCode);
			model.addAttribute("productOldprice", productOldprice);
			
			return "product";
			
		}
		
	}
	
	
	
	//로그아웃
	@RequestMapping("memberLogout")
	public String memberLogout(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		session.invalidate(); //세션 초기화
				
		model.addAttribute("sessionID", "");
		model.addAttribute("sessionNAME", "");
		return "redirect:login";
	}
		
}
