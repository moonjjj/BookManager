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

@Controller
public class AdminBookController {
	
	@Inject
	BookService bookService;
	
	
	@RequestMapping(value = "/admin/mb", method = RequestMethod.GET)
	public String manageBook(Model model) {

		bookService.bookList(model);
		
		return "admin/mb";
	}
	

	@RequestMapping(value = "/admin/mbUpdate", method = RequestMethod.GET)
	public String bookUpdate(HttpServletRequest request, HttpServletResponse response,Model model) {
		
		bookService.updateBookList(request, model);
		
		return "admin/update";
	}
	
	@RequestMapping(value = "/admin/updateAction", method = RequestMethod.POST)
	public String updateAction(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		
		if(bookService.updateAction(request, model)) {
			
			return "redirectt";
		}
			
		return "historyback";
	}
}
