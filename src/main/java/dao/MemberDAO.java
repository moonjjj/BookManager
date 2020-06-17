package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.Member;

public class MemberDAO {
	private SqlSessionFactory sqlsessionFactory = null;
	
	public MemberDAO(SqlSessionFactory sqlsessionFactory) {
		this.sqlsessionFactory = sqlsessionFactory;
	}

	public List<Member> selectAllMember() {
		List<Member> list = null;
		Member member = new Member();
		SqlSession session = sqlsessionFactory.openSession();
		try {
			list = session.selectList("Member.selectAllMember");
		}finally {
			session.close();
		}
		return list;
	}
	
	public Member selectNsearchMember(String name) {
		Member member = null;
		SqlSession session = sqlsessionFactory.openSession();
		try {
			member = session.selectOne("Member.selectMember", name);			
		}finally{
			session.close();
		}
		return member;
	}
	
	public void insertMember(Member member) {
		SqlSession session = sqlsessionFactory.openSession();
		try {
			session.insert("Member.insertMember",member);
		}finally {
			session.commit();
			session.close();
		}
		
	}
	
	public String searchmid(String numm) {
		String idx=null;
		SqlSession session = sqlsessionFactory.openSession();
		try {
			if(session.selectOne("Member.selectMemberID", numm)==null) {
				System.out.println("해당 id가 없습니다.");
			}else {
				idx = session.selectOne("Member.selectMemberID",numm);
				
			}
		}finally {
			session.close();
		}
		return idx;
	}
	
	public String searchpass(String mpasss) {
		String idx=null;
		SqlSession session = sqlsessionFactory.openSession();
		try {
			if(session.selectOne("Member.selectMemberPASS", mpasss)==null) {
				System.out.println("해당 id가 없습니다.");
			}else {
				idx = session.selectOne("Member.selectMemberPASS",mpasss);
				
			}
		}finally {
			session.close();
		}
		return idx;
	}
	public String searchname(String mid) {
		String idx=null;
		SqlSession session = sqlsessionFactory.openSession();
		try {
			idx=session.selectOne("Member.selectMemberName", mid);
			
		}finally {
			session.close();
		}
		return idx;
	}
	
	public void delete(String idxd) {
		SqlSession session = sqlsessionFactory.openSession();
		try {
			session.delete("Member.deleteMember",idxd);
		}finally {
			session.commit();
			session.close();
		}
	}
	
	public void update(Member member) {
		SqlSession session = sqlsessionFactory.openSession();
		try {
			session.update("Member.updateMember",member);
		}finally {
			session.commit();
			session.close();
		}
	}

}
