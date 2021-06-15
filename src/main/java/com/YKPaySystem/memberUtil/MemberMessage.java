package com.YKPaySystem.memberUtil;
import org.springframework.ui.Model;

public class MemberMessage {
	public static String getMemberUpdateMessage(int result, Model model) {
		if(result > 0) {								
			model.addAttribute("msg","충전이 완료 되었습니다.");	
			model.addAttribute("url", "product");		
			return "view_messagePage";
		}else {											
			return "redirect:error?msgGubun=4";			
		}	
	}
}
