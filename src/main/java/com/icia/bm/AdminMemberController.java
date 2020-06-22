package com.icia.bm;

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
public class AdminMemberController {
	
	@Inject
	MemberService memberService;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminLogin() {
		
		return "admin/login";
	}
	@RequestMapping(value = "/admin/loginaction", method = {RequestMethod.GET, RequestMethod.POST})
	public String adminAction(HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException {
		
		if(memberService.adminLogin(request, response, model)) {
			return "redirect:/admin/home";
		}
		
		return "/redirectt";
	}
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public String adminHome(HttpServletRequest request) {
		
		if(memberService.authAdmin(request)) {
			return "admin/home";
		}
		return "redirect:/admin";
	}
	@RequestMapping(value = "/admin/mm", method = RequestMethod.GET)
	public String manageMember(HttpServletRequest request, Model model) {
		if(memberService.authAdmin(request)) {
			memberService.showMembers(model);
			return "admin/mm";
		}
		return "redirect:/admin";
		
	}
	
	@RequestMapping(value = "/admin/deleteAction", method = RequestMethod.POST)
	public String deleteMember(HttpServletRequest request) {
		memberService.deleteMember(request);
		return "redirect:/admin/mm";
	}
	
	@RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request) {
		memberService.logout(request);
		return "redirect:/admin" ;
	}
}
