/* Mybatis���� ����
 * 0. SqlSessionFactoryBulider : ���� ���� �о SqlSessionFactory ����� ����
 * 1. SqlSessionFactory ���� : Mybatis�� Sql������ �����ϴ� ��ü,SqlSession�� ����� ����
 * 2. SqlSession ����(���� ���ǹ�����) : �����ͺ��̽� ���ǹ��� Ȱ���ϱ����� Ŭ���� ����
 *    - selectList() 
 *    - selectOne()
 *    - insert()
 *    - update()
 *    - delete()
 * 
 * ���̹�Ƽ���� �ҷ��� ���ǹ��� ���� �ϴ� ��
 * ��ü��ȸ, ������ȸ, ���߰�, �����, �����
 */
package dao;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.Book;

public class BookDAO {
	Scanner sc = new Scanner(System.in);
//	�ʵ�
	private SqlSessionFactory sqlSessionFactory = null;
//	�����ڿ� SqlSessionFactory�� ����
	public BookDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
//	å(check)�� ��ü��ȸ
	public List<Book> selectAll() {
	 	List<Book> list = null; //��ü��ȸ�� ����Ʈ����
		
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
	
	public List<Book> search(String bookname) {
		List<Book> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			if(session.selectList("Book.selectAll", bookname)==null) {
				
			}else {
				list = session.selectList("Book.selectAll",bookname);
			}
		}finally {
			session.close();
		}
		return list;
	}
	
//	bookname�� �̿��ؼ� bookidȣ��
	public String searchIdName(String bookname) {
		String idx=null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			if(session.selectOne("Book.searchIdName", bookname)==null) {
				System.out.println("�ش� bookid�� �����ϴ�.");
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
				System.out.println("�ش� å�� �����ϴ�.");
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
				System.out.println("�ش� id�� �����ϴ�.");
			}else {
				idx = session.selectOne("Book.searchContent",bname);
				
			}
		}finally {
			session.close();
		}
		return idx;
	}
	
	public int countResult(String bname) {
		int num =0;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			num = session.selectOne("Book.countBook",bname);
		}finally {
			session.close();
		}
		return num;
	}
	
	
	
}
