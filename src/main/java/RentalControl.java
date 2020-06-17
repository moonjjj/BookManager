import java.util.List;
import java.util.Scanner;

import dao.RentalDAO;
import model.Rental;
import mybaits.MyBatisConnectionFactory;

public class RentalControl {
	Scanner sc = new Scanner(System.in);
	RentalDAO rentalDAO = new RentalDAO(MyBatisConnectionFactory.getSqlSessionFactory());
	Rental rental = new Rental();
	List<Rental> rentalList = null;
	
	public void selectRental() {
		System.out.println("1.전체 대여 조회 2.개인 대여 조회");
		int sel = Integer.parseInt(sc.nextLine());
		if(sel==1) {
			rentalList = rentalDAO.selectAllR();
			for(Rental obj : rentalList) {
				System.out.println("회원 이름 : "+obj.getMname());
				System.out.println("대여 책이름 : "+obj.getBname());
				System.out.println("대여 날짜 : "+obj.getRdate());
			}
		}else if(sel==2) {
			
		}
	}

}
