import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSessionFactory;

import dao.BookDAO;
import dao.ManagerDAO;
import dao.MemberDAO;
import dao.PlayUserDAO;
import model.Book;
import mybaits.MyBatisConnectionFactory;

public class Main {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		MemberControl memberC = new MemberControl();
		MemberDAO memberDAO = new MemberDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		ManagerControl managerC = new ManagerControl();
		PlayUserControl playuserC = new PlayUserControl();
		ManagerDAO managerDAO = new ManagerDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		PlayUserDAO playuserDAO = new PlayUserDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		
		boolean done = true;
		
		while(done) {
			System.out.println("======Menu======");
			System.out.println("1.관리자 2.사용자 3.사용자 회원가입 4.프로그램 종료");
			int msel = Integer.parseInt(sc.nextLine());
			switch(msel) {
			case 1:
				System.out.println("<<관리자 로그인>>");
				while(true) {
					System.out.print("id : ");
					String gid = sc.nextLine();
					System.out.print("password : ");
					String gpass = sc.nextLine();
					
					String mgname = managerDAO.search(gid);
					
					if(gid.equals(mgname) && mgname!=null) {
						String mgpass = managerDAO.searchPass(mgname);
						if(!gpass.equals(mgpass)) {
							System.out.println("==> 비밀번호가 맞지 않습니다.");
						}else {
							System.out.println("로그인 성공!!");
							managerC.mControl();
							break;
						}
					}
					
				}
				break;
			case 2:
				System.out.println("<<사용자 로그인>>");
				System.out.print("id : ");
				String uid = sc.nextLine();
				System.out.println("password : ");
				String upass = sc.nextLine();
				
				String memberid = memberDAO.searchmid(uid);
				
				if(uid.equals(memberid) && memberid!=null) {
					String mpass = memberDAO.searchpass(memberid);
					if(!upass.equals(mpass)) {
						System.out.println("==> 비밀번호가 맞지 않습니다.");
					}else {
						System.out.println("로그인 성공!!");
						playuserC.pControl(memberid);
					}
				}
				break;
			case 3:
				System.out.println("<사용자 회원가입>>");
				memberC.insertMember();
				break;
			case 4:
				System.out.println("프로그램 종료");
				done = false;
				System.exit(0);
			}
		}
		
	}

}