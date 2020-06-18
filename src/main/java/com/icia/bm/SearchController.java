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
		List<Book> list = bookDAO.search(bname);
		System.out.println(bookDAO.countResult(bname));
		if(bookDAO.countResult(bname)==0) {
			model.addAttribute("msg", "조회결과없음");
		}else {
			model.addAttribute("size", list.size());
				for(int i = 0 ; i < list.size(); i++) {
					model.addAttribute("bid"+i, list.get(i).getId());
					model.addAttribute("bname"+i, list.get(i).getName());
					model.addAttribute("bcontent"+i, list.get(i).getContent());
			}
		}
		
		return "searchResult";
	}
}
