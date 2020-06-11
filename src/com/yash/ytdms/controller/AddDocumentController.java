package com.yash.ytdms.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.yash.ytdms.dao.DocumentDAO;
import com.yash.ytdms.daoimpl.DocumentDAOImpl;
import com.yash.ytdms.domain.Document;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.DocumentService;
import com.yash.ytdms.serviceimpl.DocumentServiceImpl;

/**
 * Servlet implementation class AddDocumentController
 */
@WebServlet("/AddDocumentController")
public class AddDocumentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DocumentService documentService = null;
	static final Logger LOGGER = Logger.getLogger(AddDocumentController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDocumentController() {
		super();
		documentService = (DocumentService) ObjectFactory.getObject(DocumentService.class);
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Document document = new Document();

		HttpSession session = request.getSession();
		document.setSectionId((int) session.getAttribute("sectionId"));
		document.setCategoryId((int) session.getAttribute("categoryId"));
		document.setTitle(request.getParameter("title"));
		document.setContent(request.getParameter("content"));
		try {
			documentService.save(document);
			LOGGER.info("Document Added successully");
			getServletContext().getRequestDispatcher("/ListDocumentController").forward(request, response);
		} catch (Exception e) {
			LOGGER.info("Document not created");
			response.sendRedirect("listDocument.jsp?errMsg=Document Not Added");
		}

	}

}
