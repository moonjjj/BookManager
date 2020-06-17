import java.util.Scanner;

public class PlayUserControl {
	Scanner sc = new Scanner(System.in);
	boolean done = true;
	MemberControl mControl = new MemberControl();
	BookControl bControl = new BookControl();
	RentalControl rControl = new RentalControl();
	public void pControl(String mid) {
		while(done) {
			System.out.println("1.책조회 2.회원탈퇴 3.회원수정 4.내대여목록 5.책대여 6.반납 7.종료");
			int num = Integer.parseInt(sc.nextLine());
			
			switch(num) {
			case 1:
				mControl.insertMember();
				break;
			case 2:
				mControl.deleteMember(mid);
				done = false;
				break;
			case 3:
				mControl.updateMember(mid);
				break;
			case 4:
				bControl.selectBook();
				break;
			case 5:
				bControl.rentalBook(mid);
				break;
			case 6:
				break;
			case 7:
				done = false;
				break;
			}
		}
	}

}
