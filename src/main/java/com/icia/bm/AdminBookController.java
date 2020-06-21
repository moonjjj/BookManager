package com.icia.bm;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icia.bm.bean.Book;
import com.icia.bm.dao.BookDAO;

@Controller
public class AdminBookController {
	
	@Inject
	BookDAO bookDAO;
	
	
	@RequestMapping(value = "/admin/mb", method = RequestMethod.GET)
	public String manageBook(HttpServletRequest request, HttpServletResponse response,Model model) {

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
}
