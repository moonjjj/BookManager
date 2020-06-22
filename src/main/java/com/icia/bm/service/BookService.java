package com.icia.bm.service;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.icia.bm.bean.Book;
import com.icia.bm.dao.BookDAO;

@Service
public class BookService {
	
	@Inject
	private BookDAO bookDAO;
	
	public void bookList(Model model) {
		model.addAttribute("list",bookDAO.selectAll());
	}
	
	public void updateBookList(HttpServletRequest request,Model model) {
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
	}
	
	public Boolean updateAction(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		
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
			return true;
		}else {
			model.addAttribute("msg","정보수정 실패/ 이미존재하는 아이디입니다.");
			return false;
		}
	}
	
	public void searchBook(HttpServletRequest request, Model model) {
		String bname = request.getParameter("bname");

		model.addAttribute("list",bookDAO.search(bname));
	}
}
