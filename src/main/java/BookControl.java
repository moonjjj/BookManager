import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import dao.BookDAO;
import dao.MemberDAO;
import dao.RentalDAO;
import model.Book;
import model.Rental;
import mybaits.MyBatisConnectionFactory;

public class BookControl {
	Scanner sc = new Scanner(System.in);
	BookDAO bookDAO = new BookDAO(MyBatisConnectionFactory.getSqlSessionFactory());
	MemberDAO memberDAO= new MemberDAO(MyBatisConnectionFactory.getSqlSessionFactory());
	RentalDAO rentalDAO= new RentalDAO(MyBatisConnectionFactory.getSqlSessionFactory());
	Book book = new Book();
	List<Book> booklist = null;
	boolean done = true;
	
	public void selectBook() {
		System.out.print("1.전체조회 2.개인조회");
		int sel2 = Integer.parseInt(sc.nextLine());
		if (sel2 == 1) {
//	             전체조회
			booklist = bookDAO.selectAll();
			for (Book binfo : booklist) {
				System.out.println();
				System.out.println("책 id : " + binfo.getId());
				System.out.println("책 name : " + binfo.getName());
				System.out.println("책 Content : " + binfo.getContent());
				System.out.println("책 rnum : " + binfo.getRnum());
			}
		} else if (sel2 == 2) {
//			선택조회
			System.out.print("선택조회 id : ");
			String id = sc.nextLine();
			book = bookDAO.selectById(id);
			try {
				System.out.println("책 id : " + book.getId());
				System.out.println("책 name : " + book.getName());
				System.out.println("책 Content : " + book.getContent());
				System.out.println("책 rnum : " + book.getRnum());
			} catch (NullPointerException e) {
				System.out.println("해당 id가 없습니다.");
			}
		}
	}
	
	public void insertBook() {
		System.out.println();
		System.out.print("추가할 id : ");
		String id = sc.nextLine();
		System.out.print("추가할 name : ");
		String name = sc.nextLine();
		System.out.print("추가할 content : ");
		String content = sc.nextLine();
		
		book.setId(id);
		book.setName(name);
		book.setContent(content);
		book.setRnum(0);
		
		bookDAO.insertBook(book);
		
	}
	
	public void updateBook() {
		try {
			Book book = new Book();
			System.out.print("수정할 id : ");
			String id = sc.nextLine();
			String idr = bookDAO.search(id);
			if(idr != null) {
				System.out.println(idr+"책 <수정>");
				
				System.out.print("수정할 name : ");
				String name = sc.nextLine();
				System.out.print("수정할 content : ");
				String content = sc.nextLine();
				
				book.setId(idr);
				book.setName(name);
				book.setContent(content);
				
				bookDAO.update(book);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBook() {
		try {
			System.out.print("삭제할 id : ");
			String id = sc.nextLine();
			String idr = bookDAO.search(id);
			if(idr != null) {
				bookDAO.delete(idr);
				System.out.println("삭제되었습니다.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void rentalBook(String mid) {
		Rental rental = new Rental();
		selectBook();
		System.out.print("대여할 책 이름을 입력하세요 : ");
		String rbname = sc.nextLine();
		String rbnameR = bookDAO.searchBookName(rbname);
		if(rbnameR!=null) {
			System.out.println("success");
			String rmname = memberDAO.searchname(mid);
			String rbid = bookDAO.searchIdName(rbnameR);
			String rcontent = bookDAO.searchBookContent(rbnameR);
//			Date rdate = rentalDAO.searchBookRdate(rbid);
			bookDAO.updateRnum(rbid);
			
			System.out.println(rmname);
			System.out.println(rbid);
			System.out.println(rbnameR);
			System.out.println(rcontent);
			
//			System.out.println(rentalDAO.searchBookRdate(rbid));
			
//			book.setRnum(1);
//			rental.setMname(rmname);
//			rental.setBid(rbid);
//			rental.setBname(rbname);
//			rental.setBcontent(rcontent);
//			rental.setRdate(rdate);
			
			
//			rentalDAO.insertRental(rental);
		}
	}
	
}
