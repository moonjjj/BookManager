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
			System.out.println("======������ MENU======");
			System.out.print("1.ȸ����ȸ  2.å ��ȸ  3.å �߰�  4.å ����  5.å ���� 6.�뿩��ȸ 7.����");
			int sel = Integer.parseInt(sc.nextLine());
			
			switch (sel) {
			case 1:
				System.out.println("1.��üȸ����ȸ 2.�̸����� ȸ����ȸ");
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
//				bookControl.updateBook();
				break;
			case 5:
//				bookControl.deleteBook();
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
