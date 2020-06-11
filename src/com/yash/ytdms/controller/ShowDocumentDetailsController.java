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
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.DocumentService;
import com.yash.ytdms.service.TestService;
import com.yash.ytdms.serviceimpl.DocumentServiceImpl;

/**
 * updatecontroller call from jsp page
 */
@WebServlet("/ShowDocumentDetailsController")
public class ShowDocumentDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(ShowDocumentController.class);
	private DocumentService documentService;
	private Document document = new Document();

	public ShowDocumentDetailsController() {
		documentService = (DocumentService) ObjectFactory.getObject(DocumentService.class);
	}

	/**
	 * doGet method call automatically when link is click in jsp take id and call
	 * show method in service layer
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			document = documentService.findDocument(id);
			LOGGER.info(document);
			session.setAttribute("document", document);
			response.sendRedirect("updateDocument.jsp");
		} catch (Exception e) {
			response.sendRedirect("listDocument.jsp?errMsg=Document details not found ");
		}

	}

}
