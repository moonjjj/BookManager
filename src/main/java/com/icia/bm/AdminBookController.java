package com.icia.bm;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icia.bm.service.BookService;
import com.icia.bm.service.MemberService;

@Controller
public class AdminBookController {
	
	@Inject
	BookService bookService;
	@Inject
	MemberService memberService;
	
	
	@RequestMapping(value = "/admin/mb", method = RequestMethod.GET)
	public String manageBook(HttpServletRequest request, Model model) {
		if(memberService.authAdmin(request)) {
			
			bookService.bookList(model);
			
			return "admin/mb";
		}
		return "redirect:/admin";
		
	}
	

	@RequestMapping(value = "/admin/mbUpdate", method = RequestMethod.GET)
	public String bookUpdate(HttpServletRequest request, HttpServletResponse response,Model model) {
		
		if(memberService.authAdmin(request)) {
			
			bookService.updateBookList(request, model);
			
			return "admin/update";
		}
		return "redirect:/admin";
		
	}
	
	@RequestMapping(value = "/admin/updateAction", method = RequestMethod.POST)
	public String updateAction(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		
		if(bookService.updateAction(request, model)) {
			
			return "redirectt";
		}
			
		return "historyback";
	}
}
