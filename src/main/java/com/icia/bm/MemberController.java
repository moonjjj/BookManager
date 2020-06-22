package com.icia.bm;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icia.bm.service.MemberService;

@Controller
public class MemberController {
	
	@Inject
	MemberService memberService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request)  {
		
		if(memberService.isLogOn(request)) {
			return "redirect:/";
		}
		return "login";
		
	}
	@RequestMapping(value = "/loginAction", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginAction(HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException {
		
		if(memberService.memberLogin(request, response, model)) {
			
			return "redirect:/";
		}
		return "/redirectt";
		
	}
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join";
	}

	@RequestMapping(value = "/joinAction", method = RequestMethod.POST)
	public String joinAction(HttpServletRequest request, Model model) throws IOException{
		
		if(memberService.join(request,model)) {
			return "redirect:/";
		}
		return "/redirectt";
		
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		memberService.logout(request);
		return "redirect:/" ;
	}
}
