package com.icia.bm.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.icia.bm.bean.Book;

@Repository
public class BookDAO {
	
	@Inject
	SqlSession session;
	
	public List<Book> selectAll() {
		
		return session.selectList("Book.selectAll");
	}
	
	public Book selectById(String id) {
		
		return session.selectOne("Book.selectById", id);
	}
	
	public int insertBook(Book book){
		
		return session.insert("Book.insertBook",book);
	}
	
	public void update(Book book) {
		
		session.update("Book.update",book);
	}
	
	public void updateRnum(String idx) {
		
		session.update("Book.updateRnum",idx);
	}
	public void delete(String idxd) {
		session.delete("Book.delete",idxd);
	}
	
	public List<Book> search(String bookname) {
		List<Book> list = null;
		if(session.selectList("Book.search", bookname)!=null) {
			list = session.selectList("Book.search",bookname);
		}
		
		return list;
	}
	
	public String searchIdName(String bookname) {
		String idx=null;
		if(session.selectOne("Book.searchIdName", bookname)!=null) {
			idx = session.selectOne("Book.searchIdName",bookname);
		}
		return idx;
	}
	
	public String searchBookName(String bookname) {
		String idx=null;
		if(session.selectOne("Book.searchBookname", bookname)!=null) {
			idx = session.selectOne("Book.searchBookname",bookname);
		}
		return idx;
	}
	
	public String searchBookContent(String bname) {
		String idx=null;
			if(session.selectOne("Book.searchContent", bname)!=null) {
				idx = session.selectOne("Book.searchContent",bname);
			}
		return idx;
	}
	
}
