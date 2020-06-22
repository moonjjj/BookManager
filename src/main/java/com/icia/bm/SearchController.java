package com.icia.bm;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icia.bm.service.BookService;

@Controller
public class SearchController {
	
	@Inject
	BookService bookService;
	
	@RequestMapping(value = "/bookSearch", method = RequestMethod.GET)
	public String searchbook(HttpServletRequest request, Model model) {
		
		bookService.searchBook(request, model);
		
		return "searchResult";
	}
	@RequestMapping(value = "/bookSearchAll", method = RequestMethod.GET)
	public String searchbookAll(Model model) {

		bookService.bookList(model);
		
		return "searchResult";
	}
}
