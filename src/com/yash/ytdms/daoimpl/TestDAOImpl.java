package com.yash.ytdms.daoimpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.yash.ytdms.dao.TestDAO;
import com.yash.ytdms.domain.Test;
import com.yash.ytdms.util.JNDIUtil;

public class TestDAOImpl extends JNDIUtil implements TestDAO {

	@Override
	public void save(Test test) {
		String sql = "insert into testtable(name) values(?)";
		PreparedStatement pstmt =preparedStatement(sql);
		try {
			pstmt.setString(1, test.getName());
			pstmt.execute();
		}catch (SQLException e) {
			// TODO: throw back the exception to service layer from here in case exception comes.so that user can be notified for the specific issue.
		}

	}

	@Override
	public void update(Test test) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Test test) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Test> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
