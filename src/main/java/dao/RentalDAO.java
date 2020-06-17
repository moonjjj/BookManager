package dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.Rental;

public class RentalDAO {

	private SqlSessionFactory sqlSessionFactory = null;

	public RentalDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public List<Rental> selectAllR() {
		List<Rental> list = null;

		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("Rental.selectAllR");

		return list;
	}
	
	public void insertRental(Rental rental) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("Rental.insertRentalB",rental);
		}finally {
			session.commit();
			session.close();
		}
	}
	
	public Date searchBookRdate(String bookid) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Date rdate = session.selectOne("Rental.selectBookRdate",bookid);
			return rdate;
		}finally {
			session.commit();
			session.close();
		}
		
		
	}

}
