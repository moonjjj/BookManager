package com.icia.bm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchController {
	@RequestMapping(value = "/bookSearch", method = RequestMethod.GET)
	public String searchbook(HttpServletRequest request, HttpServletResponse response) {
		
		return "searchResult";
	}
}
