package com.yash.ytdms.serviceimpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import com.yash.ytdms.dao.DocumentDAO;
import com.yash.ytdms.domain.Document;
import com.yash.ytdms.exception.DocumentException;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.DocumentService;
import com.yash.ytdms.util.JNDIUtil;
import com.yash.ytdms.util.ValidationUtil;


public class DocumentServiceImpl extends JNDIUtil implements DocumentService {
	
	private DocumentDAO documentDao;

	public DocumentServiceImpl() {
		documentDao = (DocumentDAO) ObjectFactory.getObject(DocumentDAO.class);
	}
	
	@Override
	public Document findDocument(int documentId) {
		return documentDao.searchDocumentById(documentId);
		
	}

	@Override
	public List<Document> searchBySectionId(int sectionId) {
		return  documentDao.findBySectionId(sectionId);
	}

	@Override
	public void save(Document document) {
		document.setStatus(STATUS_ENABLE);
		document.setHide(SHOW_UNHIDE);
		documentDao.insert(document);
		
	}

	@Override
	public void hideDocument(int id) {
		String sql = "UPDATE documents SET hide="+SHOW_HIDE+" WHERE id=?";
		try {
			PreparedStatement psmt = preparedStatement(sql);
			psmt.setInt(1, id);
			psmt.execute();
		} catch (SQLException e) {
		}finally {
			closeConnection();
		}
		
	}

	@Override
	public void updateTrash(int documentId) {
		String sql = "update documents set hide="+SHOW_UNHIDE+" where id="+documentId;
		PreparedStatement pstmt = preparedStatement(sql);
		try {
			pstmt.execute();
		} catch (SQLException e) {
		}finally {
			closeConnection();
		}
		
	}

	@Override
	public List<Document> showTrash() {
		return documentDao.showTrash();
	}


	@Override
	public void delete(int id) {
		documentDao.delete(id);
		
	}

	@Override
	public void disableStatus(int documentId) {
		String sql=" UPDATE documents SET status=0  WHERE id="+documentId;
		PreparedStatement pstmt=preparedStatement(sql);
		try {
			pstmt.execute();
		} catch (SQLException e) {
			
		}finally {
			closeConnection();
		}
		
	}

	@Override
	public void enableStatus(int documentId) {
		String sql=" UPDATE documents SET status=1  WHERE id="+documentId;
		PreparedStatement pstmt=preparedStatement(sql);
		try {
			pstmt.execute();
		} catch (SQLException e) {

		}finally {
			closeConnection();
		}
		
	}

	@Override
	public void updateDocument(Document document) throws DocumentException {
		if (ValidationUtil.validateContent(document.getContent(),0)) {
			documentDao.updateDocument(document);
		} else {
			throw new DocumentException("content should be morer than 0");
		}
		
	}

}
