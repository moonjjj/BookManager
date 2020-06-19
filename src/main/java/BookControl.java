import java.util.List;
import java.util.Scanner;

import dao.BookDAO;
import dao.MemberDAO;
import dao.RentalDAO;
import model.Book;
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
		System.out.print("1.��ü��ȸ 2.������ȸ");
		int sel2 = Integer.parseInt(sc.nextLine());
		if (sel2 == 1) {
//	             ��ü��ȸ
			booklist = bookDAO.selectAll();
			for (Book binfo : booklist) {
				System.out.println();
				System.out.println("å id : " + binfo.getId());
				System.out.println("å name : " + binfo.getName());
				System.out.println("å Content : " + binfo.getContent());
				System.out.println("å rnum : " + binfo.getRnum());
			}
		} else if (sel2 == 2) {
//			������ȸ
			System.out.print("������ȸ id : ");
			String id = sc.nextLine();
			book = bookDAO.selectById(id);
			try {
				System.out.println("å id : " + book.getId());
				System.out.println("å name : " + book.getName());
				System.out.println("å Content : " + book.getContent());
				System.out.println("å rnum : " + book.getRnum());
			} catch (NullPointerException e) {
				System.out.println("�ش� id�� �����ϴ�.");
			}
		}
	}
	
	public void insertBook() {
		System.out.println();
		System.out.print("�߰��� id : ");
		String id = sc.nextLine();
		System.out.print("�߰��� name : ");
		String name = sc.nextLine();
		System.out.print("�߰��� content : ");
		String content = sc.nextLine();
		
		book.setId(id);
		book.setName(name);
		book.setContent(content);
		book.setRnum(0);
		
		bookDAO.insertBook(book);
		
	}
	
//	public void updateBook() {
//		try {
//			Book book = new Book();
//			System.out.print("������ id : ");
//			String id = sc.nextLine();
//			String idr = bookDAO.search(id);
//			if(idr != null) {
//				System.out.println(idr+"å <����>");
//				
//				System.out.print("������ name : ");
//				String name = sc.nextLine();
//				System.out.print("������ content : ");
//				String content = sc.nextLine();
//				
//				book.setId(idr);
//				book.setName(name);
//				book.setContent(content);
//				
//				bookDAO.update(book);
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	public void deleteBook() {
//		try {
//			System.out.print("������ id : ");
//			String id = sc.nextLine();
//			String idr = bookDAO.search(id);
//			if(idr != null) {
//				bookDAO.delete(idr);
//				System.out.println("�����Ǿ����ϴ�.");
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public void rentalBook(String mid) {
		selectBook();
		System.out.print("�뿩�� å �̸��� �Է��ϼ��� : ");
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
