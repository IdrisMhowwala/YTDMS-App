package com.yash.ytdms.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.ytdms.dao.DocumentDAO;
import com.yash.ytdms.domain.Document;
import com.yash.ytdms.util.JNDIUtil;

public class DocumentDAOImpl extends JNDIUtil implements DocumentDAO {

	private Document document;

	@Override
	public List<Document> findBySectionId(int sectionId) {
		List<Document> documents = new ArrayList<>();
		String sql = "Select * from documents where sectionId =? AND hide="+SHOW_UNHIDE;
		PreparedStatement pstmt = preparedStatement(sql);
		try {
			pstmt.setInt(1, sectionId);
			ResultSet rs = pstmt.executeQuery();
			sectionIdMapping(documents, rs);
		} catch (SQLException exception) {
			//Throwing exception to the service layer
		}
		finally {
			closeConnection();
		}
		return documents;
	}

	private void sectionIdMapping(List<Document> documents, ResultSet rs) throws SQLException {
		while (rs.next()) {
			document = new Document();
			mapRow(document, rs);
			documents.add(document);		
			}
	}

	@Override
	public Document searchDocumentById(int id)  {
		Document document= new Document();
		String sql="SELECT * FROM documents WHERE id = ?";
		PreparedStatement pstmt = preparedStatement(sql);
		try {
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) 
				mapRow(document, rs);
		} catch (SQLException exception) {
			//Throwing exception to the service layer
			}
		finally {
			closeConnection();
		}
		return document;
	}
	
	private void mapRow(Document document, ResultSet rs) throws SQLException {
		document.setId(rs.getInt("id"));
		document.setSectionId(rs.getInt("sectionId"));
		document.setCategoryId(rs.getInt("categoryId"));
		document.setUserId(rs.getInt("userId"));
		document.setHide(rs.getInt("hide"));
		document.setStatus(rs.getInt("status"));
		document.setContent(rs.getString("content"));
		document.setTitle(rs.getString("title"));
	}

	@Override
	public void insert(Document document) {
		String sql = "INSERT INTO documents (userId, categoryId, sectionId, content, STATUS,hide, title) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement pstmt =preparedStatement(sql);
		try {
			setDocumentData(document, pstmt);
		} catch (SQLException e) {
			//Throwing exception to the service layer
		}
		finally {
			closeConnection();
		}
	}

	private void setDocumentData(Document document, PreparedStatement pstmt) throws SQLException {
		pstmt.setInt(1, document.getUserId());
		pstmt.setInt(2,  document.getCategoryId());
		pstmt.setInt(3, document.getSectionId());
		pstmt.setString(4, document.getContent());
		pstmt.setInt(5, document.getStatus());
		pstmt.setInt(6, document.getHide());
		pstmt.setString(7, document.getTitle());
		pstmt.execute();
	}

	@Override
	public void delete(int id) {
		String sql = "delete from documents where id="+id;
		try {
			preparedStatement(sql).execute();
		} catch (SQLException e) {
			//Throwing exception to the service layer
		}
		
	}

	@Override
	public List<Document> showTrash() {
		String sql = "select * from documents where hide="+SHOW_HIDE;
		PreparedStatement pstmt = preparedStatement(sql);
		List<Document> documents = null;
		try {
			ResultSet rs = pstmt.executeQuery();
			documents = new ArrayList<>();
			while(rs.next()) {
				document = new Document();
				mapRow(document, rs);
				documents.add(document);
			}
		} catch (SQLException e) {
			//Throwing exception to the service layer
		}finally {
			closeConnection();
		}
		return documents;
	}

	@Override
	public void updateDocument(Document document) {
		int id = document.getId();
		String sql = "update documents  set content=?, title=? where id=?";
		try {
			PreparedStatement pstmt = preparedStatement(sql);
			pstmt.setString(1, document.getContent());
			pstmt.setString(2, document.getTitle());
			pstmt.setInt(3,document.getId());
			pstmt.execute();

		} catch (Exception e) {
			//Throwing exception to the service layer
		}finally {
			closeConnection();
		}
	}
}
