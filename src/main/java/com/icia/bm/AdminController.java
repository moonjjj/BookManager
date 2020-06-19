package com.icia.bm;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.BookDAO;
import dao.MemberDAO;
import model.Book;
import mybaits.MyBatisConnectionFactory;

@Controller
public class AdminController {
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminLogin(HttpServletRequest request, HttpServletResponse response,Model model) {
		
		return "admin/login";
	}
	@RequestMapping(value = "/admin/loginaction", method = {RequestMethod.GET, RequestMethod.POST})
	public String adminAction(HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		try {
			MemberDAO memberDAO = new MemberDAO(MyBatisConnectionFactory.getSqlSessionFactory());
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
					return "redirect:/admin/home";
				}else {
					model.addAttribute("msg","아이디나 비밀번호가 다릅니다.");
		            model.addAttribute("url","/bm/admin");
				}
			}
		}catch(NullPointerException e) {
			model.addAttribute("msg","아이디나 비밀번호가 다릅니다.");
            model.addAttribute("url","/bm/admin");
		}
		return "/redirectt";
		
	}
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public String adminHome(HttpServletRequest request, HttpServletResponse response,Model model) {
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		if(mid.equals("root")) {
			return "admin/home";
		}else {
			return "redirect:/admin";
		}
	}
	@RequestMapping(value = "/admin/mm", method = RequestMethod.GET)
	public String manageMember(HttpServletRequest request, HttpServletResponse response,Model model) {
		
		return "admin/mm";
	}
	@RequestMapping(value = "/admin/mb", method = RequestMethod.GET)
	public String manageBook(HttpServletRequest request, HttpServletResponse response,Model model) {

		BookDAO bookDAO = new BookDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		model.addAttribute("list",bookDAO.selectAll());
		
		return "admin/mb";
	}
	@RequestMapping(value = "/admin/mbUpdate", method = RequestMethod.GET)
	public String bookUpdate(HttpServletRequest request, HttpServletResponse response,Model model) {
		String bid = request.getParameter("bid");
		String bname=request.getParameter("bname");
		String bcontent=request.getParameter("bcontent");
		String rnum = request.getParameter("rnum");
		String thumbnail = request.getParameter("thumbnail");
		
		model.addAttribute("bid", bid);
		model.addAttribute("bname", bname);
		model.addAttribute("bcontent", bcontent);
		model.addAttribute("rnum", rnum);
		model.addAttribute("thumbnail", thumbnail);
		
		
		return "admin/update";
	}
	@RequestMapping(value = "/admin/updateAction", method = RequestMethod.POST)
	public String updateAction(HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException {
		BookDAO bookDAO = new BookDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		request.setCharacterEncoding("utf-8");
		Book book = new Book();
		String bid = request.getParameter("bid");
		String bname=request.getParameter("bname");
		String bcontent=request.getParameter("bcontent");
		int rnum = Integer.parseInt(request.getParameter("rnum"));
		String thumbnail = request.getParameter("thumbnail");
		
		if(bookDAO.selectById(bid)==null || bookDAO.selectById(bid).getId().equals(bid)) {
			book.setId(bid);
			book.setName(bname);
			book.setContent(bcontent);
			book.setRnum(rnum);
			book.setThumbnail(thumbnail);
			bookDAO.update(book);
			model.addAttribute("msg","정보수정 성공!");
			model.addAttribute("url","/bm/admin/mb");
			return "redirectt";
		}else {
			
			model.addAttribute("msg","정보수정 실패/ 이미존재하는 아이디입니다.");
			return "historyback";
			
		}
		
		
		
		
	}
	@RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/admin" ;
	}
}
