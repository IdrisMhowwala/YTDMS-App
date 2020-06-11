package com.yash.ytdms.service;

import java.util.List;
import com.yash.ytdms.domain.Document;
import com.yash.ytdms.exception.DocumentException;

/**
 * This DocumentService interface will be performing business service on Document
 * @author samay.jain
 *
 */
public interface DocumentService {
	int STATUS_ENABLE=1;
	int STATUS_DISABLE=0;
	int SHOW_HIDE=0;
	int SHOW_UNHIDE=1;
	
	
	/**
	 * This save method will save the document in the system
	 * @param document to be save in system
	 */
	void save(Document document);

	/**
	 * This findDocumnet method is used to find a document in the system based on the provided id
	 * @param documentId of the document to find in the system
	 * @return document
	 */
	public Document findDocument(int documentId);
	
	/**
	 * This method will return all the document from the system with the specified section Id
	 * @param sectionId of the document
	 * @return list of Documents
	 */
	public List<Document> searchBySectionId(int sectionId);
	
	/**
	 * This hide method will hide the document on the basis of documentId
	 * @param documentId of the document to be hide
	 */
	void hideDocument(int id);
	

	/**
	 * This updateTrash method will update the section trash on the basis of document Id
	 * @param documentId of the document to update the trash
	 */
	void updateTrash(int documentId);
	
	/**
	 * show trash will list all the documents which are in trash
	 * @return list: list of documents which are in trash
	 */
	java.util.List<Document> showTrash();

	/**
	 * This delete method will delete the document from the system based on the provided id
	 * @param id of the document to be deleted
	 */
	void delete(int id);
	
	/**
	 * This method will update the status of the particular document to 0 in database based on provided id
	 */
	void disableStatus(int documentId);
	
	/**
	 * This method will update the status of the particular document to 1 in database based on provided id
	 */
	void enableStatus(int documentId);
	
	/**
	 * This updateDocument method is used to update the particular document in database on provided id
	 * @param document
	 * @throws DocumentException
	 */
	void updateDocument(Document document) throws DocumentException;


}
