package com.icia.bm;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dao.MemberDAO;
import model.Member;
import mybaits.MyBatisConnectionFactory;

@Controller
public class MemberController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session = request.getSession();
		
		if((Boolean)session.getAttribute("isLogon")!=null) {
			return "redirect:/";
		}else {
			return "login";
		}
	}
	@RequestMapping(value = "/loginAction", method = {RequestMethod.POST})
	public String loginAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		MemberDAO memberDAO = new MemberDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		String memberid = memberDAO.searchmid(mid);
		String memberpass = memberDAO.searchpass(memberid);
		
		
		if(mid.equals(memberid)&&mpass.equals(memberpass)) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogon", true);
			session.setAttribute("mid", mid);
			return "redirect:/";
		}else {
			return "login";
		}
	}
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join";
	}

	@RequestMapping(value = "/joinAction", method = RequestMethod.POST)
	public String joinAction(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		PrintWriter out = response.getWriter();
		MemberDAO memberDAO = new MemberDAO(MyBatisConnectionFactory.getSqlSessionFactory());
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
		
		return "redirect:/";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/" ;
	}
}
