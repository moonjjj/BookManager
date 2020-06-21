package com.icia.bm;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icia.bm.dao.BookDAO;

@Controller
public class SearchController {
	
	@Inject
	BookDAO bookDAO;
	
	@RequestMapping(value = "/bookSearch", method = RequestMethod.GET)
	public String searchbook(HttpServletRequest request, HttpServletResponse response,Model model) {
		
		String bname = request.getParameter("bname");

		model.addAttribute("list",bookDAO.search(bname));
		
		return "searchResult";
	}
	@RequestMapping(value = "/bookSearchAll", method = RequestMethod.GET)
	public String searchbookAll(HttpServletRequest request, HttpServletResponse response,Model model) {

		model.addAttribute("list",bookDAO.selectAll());
		
		return "searchResult";
	}
}
