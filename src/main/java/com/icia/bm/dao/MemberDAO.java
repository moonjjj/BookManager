package com.icia.bm.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.icia.bm.bean.Member;

@Repository
public class MemberDAO {
	
	@Inject
	SqlSession session;
	
	public List<Member> selectAllMember() {
		
		return session.selectList("Member.selectAllMember");
	}
	
	public Member selectNsearchMember(String name) {
		
		return session.selectOne("Member.selectMember", name);			
	}
	
	public void insertMember(Member member) {
		
		session.insert("Member.insertMember",member);
	}
	
	public String searchmid(String numm) {
		String idx=null;
		if(session.selectOne("Member.selectMemberID", numm)!=null) {
			idx = session.selectOne("Member.selectMemberID",numm);
		}
		return idx;
	}
	
	public String searchpass(String mpasss) {
		String idx=null;
		if(session.selectOne("Member.selectMemberPASS", mpasss)!=null) {
			idx = session.selectOne("Member.selectMemberPASS",mpasss);
		}
		return idx;
	}
	
	public String searchname(String mid) {
		
		return session.selectOne("Member.selectMemberName", mid);
	}
	
	public void delete(String idxd) {
		session.delete("Member.deleteMember",idxd);
	}
	
	public void update(Member member) {
		session.update("Member.updateMember",member);
	}

}
