package com.yash.ytdms.dao;

import java.util.List;

import com.yash.ytdms.domain.Document;

/**
 * This DocumentDAO will perform all the CRUD operations related to Document
 * @author samay.jain
 *
 */
public interface DocumentDAO {
	public static final int STATUS_ENABLE=1;
	public static final int STATUS_DISABLE=0;
	public static final int SHOW_HIDE=0;
	public static final int SHOW_UNHIDE=1;
	
	/**
	 * The insert method takes a document parameter and then saves the document 
	 * @param document
	 */
	
	void insert(Document document);
	
	/**
	 * This searchById method is used to find a document in the repository based on the provided id
	 * @param id of the document to find in the repository
	 * @return document
	 */
	public Document searchDocumentById(int id);
	

	/**
	 * This method will return all the document from the repository with the specified section Id
	 * @param sectionId of the document
	 * @return list of Documents
	 */
	public List<Document> findBySectionId(int sectionId);
	
	/**
	 * This delete method will remove the document from the repository
	 * @param id of the document to be deleted
	 */
	void delete(int id);
	
	/**
	 * This showTrash method is used to get the list of all document which are trash
	 * @return list of trash document
	 */
	public List<Document> showTrash();
	
	/**
	 * This update method will update the document in the repository
	 * @param document to be updated
	 */
	void updateDocument(Document document);

}
