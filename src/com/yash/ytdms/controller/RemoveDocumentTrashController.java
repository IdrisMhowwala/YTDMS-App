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
 * Servlet implementation class RemoveFromTrash
 */
@WebServlet("/RemoveDocumentTrashController")
public class RemoveDocumentTrashController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DocumentService documentService = null;
	static final Logger LOGGER = Logger.getLogger(RemoveDocumentTrashController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveDocumentTrashController() {
		super();
		documentService = (DocumentService) ObjectFactory.getObject(DocumentService.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int categoryId = Integer.parseInt(request.getParameter("id"));
		try {
			documentService.delete(categoryId);
			LOGGER.info("document succesfully deleted");
			getServletContext().getRequestDispatcher("/ShowTrashListController").forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("listDocument.jsp?errMsg=Document is not Removed ");
		}
	}

}
