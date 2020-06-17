/* Mybatis사용시 순서
 * 0. SqlSessionFactoryBulider : 설정 정보 읽어서 SqlSessionFactory 만드는 역할
 * 1. SqlSessionFactory 생성 : Mybatis와 Sql서버를 연결하는 객체,SqlSession을 만드는 역할
 * 2. SqlSession 생성(실제 질의문실행) : 데이터베이스 질의문을 활용하기위한 클래스 생성
 *    - selectList() 
 *    - selectOne()
 *    - insert()
 *    - update()
 *    - delete()
 * 
 * 마이바티스를 불러서 질의문을 실행 하는 곳
 * 전체조회, 선택조회, 행추가, 행수정, 행삭제
 */
package dao;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.Book;

public class BookDAO {
	Scanner sc = new Scanner(System.in);
//	필드
	private SqlSessionFactory sqlSessionFactory = null;
//	생성자에 SqlSessionFactory를 생성
	public BookDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
//	책(check)의 전체조회
	public List<Book> selectAll() {
	 	List<Book> list = null; //전체조회시 리스트보관
		
	 	SqlSession session = sqlSessionFactory.openSession();
		
		list = session.selectList("Book.selectAll");
		
		return list;
	}
	
	public Book selectById(String id) {
		Book book = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			book = session.selectOne("Book.selectById", id);
		}finally {
			session.close();
		}
		return book;
	}
	
	public int insertBook(Book book){
		int id = -1;
		SqlSession session = sqlSessionFactory.openSession();

		try {
			id = session.insert("Book.insertBook",book);
		}finally{
			session.commit();
			session.close();
		}
		return id;
	}
	
	public void update(Book book) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.update("Book.update",book);
		}finally {
			session.commit();
			session.close();
		}
	}
	
	public void updateRnum(String idx) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("Book.updateRnum",idx);
		}finally {
			session.commit();
			session.close();
		}
		
	}
	public void delete(String idxd) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("Book.delete",idxd);
		}finally {
			session.commit();
			session.close();
		}
	}
	
	public String search(String bookname) {
		String idx=null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			if(session.selectOne("Book.searchOne", bookname)==null) {
				System.out.println("해당 bookid가 없습니다.");
			}else {
				idx = session.selectOne("Book.searchOne",bookname);
				
			}
		}finally {
			session.close();
		}
		return idx;
	}
	
//	bookname을 이용해서 bookid호출
	public String searchIdName(String bookname) {
		String idx=null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			if(session.selectOne("Book.searchIdName", bookname)==null) {
				System.out.println("해당 bookid가 없습니다.");
			}else {
				idx = session.selectOne("Book.searchIdName",bookname);
				
			}
		}finally {
			session.close();
		}
		return idx;
	}
	
	public String searchBookName(String bookname) {
		String idx=null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			if(session.selectOne("Book.searchBookname", bookname)==null) {
				System.out.println("해당 책이 없습니다.");
			}else {
				idx = session.selectOne("Book.searchBookname",bookname);
				
			}
		}finally {
			session.close();
		}
		return idx;
	}
	
	public String searchBookContent(String bname) {
		String idx=null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			if(session.selectOne("Book.searchContent", bname)==null) {
				System.out.println("해당 id가 없습니다.");
			}else {
				idx = session.selectOne("Book.searchContent",bname);
				
			}
		}finally {
			session.close();
		}
		return idx;
	}
	
	
	
}
