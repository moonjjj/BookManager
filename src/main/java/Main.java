import java.util.Scanner;


import dao.ManagerDAO;
import dao.MemberDAO;
import mybaits.MyBatisConnectionFactory;

public class Main {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		MemberControl memberC = new MemberControl();
		MemberDAO memberDAO = new MemberDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		ManagerControl managerC = new ManagerControl();
		PlayUserControl playuserC = new PlayUserControl();
		ManagerDAO managerDAO = new ManagerDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		
		boolean done = true;
		
		while(done) {
			System.out.println("======Menu======");
			System.out.println("1.������ 2.����� 3.����� ȸ������ 4.���α׷� ����");
			int msel = Integer.parseInt(sc.nextLine());
			switch(msel) {
			case 1:
				System.out.println("<<������ �α���>>");
				while(true) {
					System.out.print("id : ");
					String gid = sc.nextLine();
					System.out.print("password : ");
					String gpass = sc.nextLine();
					
					String mgname = managerDAO.search(gid);
					
					if(gid.equals(mgname) && mgname!=null) {
						String mgpass = managerDAO.searchPass(mgname);
						if(!gpass.equals(mgpass)) {
							System.out.println("==> ��й�ȣ�� ���� �ʽ��ϴ�.");
						}else {
							System.out.println("�α��� ����!!");
							managerC.mControl();
							break;
						}
					}
					
				}
				break;
			case 2:
				System.out.println("<<����� �α���>>");
				System.out.print("id : ");
				String uid = sc.nextLine();
				System.out.println("password : ");
				String upass = sc.nextLine();
				
				String memberid = memberDAO.searchmid(uid);
				
				if(uid.equals(memberid) && memberid!=null) {
					String mpass = memberDAO.searchpass(memberid);
					if(!upass.equals(mpass)) {
						System.out.println("==> ��й�ȣ�� ���� �ʽ��ϴ�.");
					}else {
						System.out.println("�α��� ����!!");
						playuserC.pControl(memberid);
					}
				}
				break;
			case 3:
				System.out.println("<����� ȸ������>>");
				memberC.insertMember();
				break;
			case 4:
				System.out.println("���α׷� ����");
				done = false;
				System.exit(0);
			}
		}
		
	}

}