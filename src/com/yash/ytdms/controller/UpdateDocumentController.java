package com.yash.ytdms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.yash.ytdms.domain.Document;
import com.yash.ytdms.exception.DocumentException;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.DocumentService;
import com.yash.ytdms.service.TestService;
import com.yash.ytdms.serviceimpl.DocumentServiceImpl;

/**
 * controller call from jsp page
 */
@WebServlet("/UpdateDocumentController")
public class UpdateDocumentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(CreateTestController.class);
	private DocumentService documentService;
	private Document document;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDocumentController() {
		documentService = (DocumentService) ObjectFactory.getObject(DocumentService.class);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response) call when button submitted and set attribute in class by
	 *      session call update method in service layer
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Document document = (Document) session.getAttribute("document");
		document.setContent(request.getParameter("content"));
		document.setTitle(request.getParameter("title"));

		try {
			documentService.updateDocument(document);
			LOGGER.info("update successfull");
			getServletContext().getRequestDispatcher("/ListDocumentController").forward(request, response);

		} catch (DocumentException e) {
			response.sendRedirect("updateDocument.jsp?errMsg=Document is not updated ");
		
		}
		
	}

}
