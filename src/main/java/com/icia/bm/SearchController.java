package com.icia.bm;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mybaits.MyBatisConnectionFactory;

import dao.BookDAO;
import model.Book;

@Controller
public class SearchController {
	@RequestMapping(value = "/bookSearch", method = RequestMethod.GET)
	public String searchbook(HttpServletRequest request, HttpServletResponse response,Model model) {
		BookDAO bookDAO = new BookDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		
		String bname = request.getParameter("bname");

		model.addAttribute("list",bookDAO.search(bname));
		
		return "searchResult";
	}
	@RequestMapping(value = "/bookSearchAll", method = RequestMethod.GET)
	public String searchbookAll(HttpServletRequest request, HttpServletResponse response,Model model) {
		BookDAO bookDAO = new BookDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		

		model.addAttribute("list",bookDAO.selectAll());
		
		return "searchResult";
	}
}
