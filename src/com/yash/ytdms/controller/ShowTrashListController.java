package com.yash.ytdms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.yash.ytdms.domain.Document;
import com.yash.ytdms.exception.TestException;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.DocumentService;
import com.yash.ytdms.service.TestService;

/**
 * Servlet implementation class ShowTrashListController
 */
@WebServlet("/ShowTrashListController")
public class ShowTrashListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DocumentService documentService = null;
	static final Logger LOGGER = Logger.getLogger(ShowTrashListController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowTrashListController() {
		super();
		documentService = (DocumentService) ObjectFactory.getObject(DocumentService.class);
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			List<Document> documents = documentService.showTrash();
			LOGGER.info("document created successully");
			session.setAttribute("documents", documents);
			response.sendRedirect("trashList.jsp");
		} catch (Exception e) {
			response.sendRedirect("listDocument.jsp?errMsg=trash list not found ");
		}
	}

}
