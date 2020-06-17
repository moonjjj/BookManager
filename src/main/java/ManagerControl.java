import java.util.Scanner;

import model.Book;

public class ManagerControl {
	Scanner sc = new Scanner(System.in);
	boolean done = true;
	BookControl bookControl = new BookControl();
	MemberControl memberControl = new MemberControl();
	RentalControl rentalControl = new RentalControl();
	
	
	public void mControl(){
		while (done) {
			System.out.println("======관리자 MENU======");
			System.out.print("1.회원조회  2.책 조회  3.책 추가  4.책 수정  5.책 삭제 6.대여조회 7.종료");
			int sel = Integer.parseInt(sc.nextLine());
			
			switch (sel) {
			case 1:
				System.out.println("1.전체회원조회 2.이름으로 회원조회");
				int selnumm = Integer.parseInt(sc.nextLine());
				if(selnumm==1) {
					memberControl.selectAMember();
				}else if(selnumm==2) {
					memberControl.selectNMember();
				}
				break;
			case 2:
				bookControl.selectBook();
				break;

			case 3:
				bookControl.insertBook();
				break;
			case 4:
				bookControl.updateBook();
				break;
			case 5:
				bookControl.deleteBook();
				break;
			case 6:
				rentalControl.selectRental();
				break;
			case 7:
				done = false;
				break;
			}
			
		}
	}

}
