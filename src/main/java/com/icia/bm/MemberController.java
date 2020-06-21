package com.icia.bm;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icia.bm.bean.Member;
import com.icia.bm.dao.MemberDAO;

@Controller
public class MemberController {
	
	@Inject
	MemberDAO memberDAO;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session = request.getSession();
		
		if((Boolean)session.getAttribute("isLogon")!=null) {
			return "redirect:/";
		}else {
			return "login";
		}
	}
	@RequestMapping(value = "/loginAction", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginAction(HttpServletRequest request, HttpServletResponse response,Model model) throws IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		try {
			String memberid = memberDAO.searchmid(mid);
			String memberpass = memberDAO.searchpass(memberid);
			if(mid.equals(memberid)&&mpass.equals(memberpass)) {
				HttpSession session = request.getSession();
				session.setAttribute("isLogon", true);
				session.setAttribute("mid", mid);
				return "redirect:/";
			}else {
				model.addAttribute("msg","아이디나 비밀번호가 다릅니다.");
	            model.addAttribute("url","/bm/login");
			}
		}catch(NullPointerException e) {
			model.addAttribute("msg","아이디나 비밀번호가 다릅니다.");
            model.addAttribute("url","/bm/login");
		}
		return "/redirectt";
		
	}
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join";
	}

	@RequestMapping(value = "/joinAction", method = RequestMethod.POST)
	public String joinAction(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		Member member = new Member();
		request.setCharacterEncoding("utf-8");
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		String mname = request.getParameter("mname");
		String etc = request.getParameter("etc");
		member.setMid(mid);
		member.setMpass(mpass);
		member.setMname(mname);
		member.setEtc(etc);
		memberDAO.insertMember(member);
		
		HttpSession session = request.getSession();
		session.setAttribute("isLogon", true);
		session.setAttribute("mid",mid);
		
		return "redirect:/";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/" ;
	}
}
