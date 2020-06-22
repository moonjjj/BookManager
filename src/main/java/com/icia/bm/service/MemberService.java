package com.icia.bm.service;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.icia.bm.bean.Member;
import com.icia.bm.dao.MemberDAO;

@Service
public class MemberService {
	
	@Inject
	private MemberDAO memberDAO;
	
	public boolean adminLogin(HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		try {
			String memberid = memberDAO.searchmid(mid);
			if(!memberid.equals("root")) {
				model.addAttribute("msg","아이디나 비밀번호가 다릅니다.");
	            model.addAttribute("url","/bm/admin");
			}else {
				String memberpass = memberDAO.searchpass(memberid);
				if(mid.equals(memberid)&&mpass.equals(memberpass)) {
					HttpSession session = request.getSession();
					session.setAttribute("isLogon", true);
					session.setAttribute("mid", mid);
					return true;
				}else {
					model.addAttribute("msg","아이디나 비밀번호가 다릅니다.");
		            model.addAttribute("url","/bm/admin");
				}
			}
		}catch(NullPointerException e) {
			model.addAttribute("msg","아이디나 비밀번호가 다릅니다.");
            model.addAttribute("url","/bm/admin");
		}
		return false;
		
	}
	
	public boolean authAdmin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		if(mid.equals("root")) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isLogOn(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		if((Boolean)session.getAttribute("isLogon")!=null) {
			return true;
		}
		
		return false;
		
	}

	public boolean memberLogin(HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException {
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
				return true;
			}else {
				model.addAttribute("msg","아이디나 비밀번호가 다릅니다.");
	            model.addAttribute("url","/bm/login");
			}
		}catch(NullPointerException e) {
			model.addAttribute("msg","아이디나 비밀번호가 다릅니다.");
            model.addAttribute("url","/bm/login");
		}
		return false;
		
	}
	
	public boolean join(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		try {
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
			return true;
		}catch(Exception e) {
			model.addAttribute("msg","아이디나 비밀번호가 다릅니다.");
            model.addAttribute("url","/bm/admin");
			return false;
		}
		
	}
	
	public void showMembers(Model model) {
		model.addAttribute("list",memberDAO.selectAllMember());
	}
	
	public void deleteMember(HttpServletRequest request) {
		String mid = request.getParameter("mid");
		memberDAO.delete(mid);
	}
	
	public void logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
	}
}
