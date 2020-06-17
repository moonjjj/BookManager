import java.util.List;
import java.util.Scanner;

import dao.MemberDAO;
import model.Member;
import mybaits.MyBatisConnectionFactory;

public class MemberControl {
	Scanner sc = new Scanner(System.in);
	MemberDAO memberDAO = new MemberDAO(MyBatisConnectionFactory.getSqlSessionFactory());
	
	public void selectAMember() {
		List<Member> memberList = null;
		memberList = memberDAO.selectAllMember();
		for(Member obj : memberList) {
			System.out.println();
			System.out.println("회원 id : "+obj.getMid());
			System.out.println("회원 password : "+obj.getMpass());
			System.out.println("회원 name : "+obj.getMname());
			System.out.println("etc : "+obj.getEtc());
		}
		
	}

	public void selectNMember() {
		Member member = new Member();
		System.out.print("회원 name : ");
		String mname = sc.nextLine();
		try {
			member = memberDAO.selectNsearchMember(mname);
			System.out.println("회원 id : "+member.getMid());
			System.out.println("회원 password : "+member.getMpass());
			System.out.println("회원 name : "+member.getMname());
			System.out.println("etc : "+member.getEtc());
			System.out.println(member.getMid()+"님!! 회원가입을 축하드립니다!!");
		}catch(NullPointerException e) {
			System.out.println("존재하지 않는 회원입니다.");
		}
		
	}
	
	public void insertMember() {
		Member member = new Member();
		System.out.println("회원 id : ");
		String mid = sc.nextLine();
		System.out.println("회원 password : ");
		String mpass = sc.nextLine();
		System.out.println("회원 name : ");
		String mname = sc.nextLine();
		System.out.println("etc : ");
		String etc = sc.nextLine();
		
		member.setMid(mid);
		member.setMpass(mpass);
		member.setMname(mname);
		member.setEtc(etc);
		
		memberDAO.insertMember(member);
	}
	
	public void deleteMember(String mid) {
		try {
			String idr = memberDAO.searchmid(mid);
			if(idr != null && mid.equals(idr)) {
				System.out.print("탈퇴할 비밀번호 : ");
				String pass = sc.nextLine();
				String passr = memberDAO.searchpass(idr);
				if(passr.equals(pass)) {
					memberDAO.delete(idr);
					System.out.println("탈퇴되었습니다.");
				}else {
					System.out.println("패스워드가 일치하지 않습니다.");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateMember(String mid) {
		try {
			
			String idr = memberDAO.searchmid(mid);
			if (idr != null && idr.equals(mid)) {
				Member member = new Member();
				System.out.println(idr + "책 <수정>");

				System.out.print("수정할 password : ");
				String mpass = sc.nextLine();
				System.out.print("수정할 name : ");
				String mname = sc.nextLine();
				System.out.print("수정할 etc : ");
				String etc = sc.nextLine();
				
				member.setMid(idr);
				member.setMpass(mpass);
				member.setMname(mname);
				member.setEtc(etc);
				
				memberDAO.update(member);
				System.out.println("수정이 완료되었습니다.");
			}else {
				System.out.println("회원이 존재하지 않습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
