package com.yash.ytdms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.DocumentService;

/**
 * Servlet implementation class RestoreDocumentController
 */
@WebServlet("/RestoreDocumentController")
public class RestoreDocumentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DocumentService documentService = null;
	static final Logger LOGGER = Logger.getLogger(RestoreDocumentController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RestoreDocumentController() {
		super();
		documentService = (DocumentService) ObjectFactory.getObject(DocumentService.class);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int documentId = Integer.parseInt(request.getParameter("id"));
		try {
			documentService.updateTrash(documentId);
			LOGGER.info("document succesfully removed from trash");
			getServletContext().getRequestDispatcher("/ShowTrashListController").forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("listDocument.jsp?errMsg=Document is not Restored ");
		}
	}

}
