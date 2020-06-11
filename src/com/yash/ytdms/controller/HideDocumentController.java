package com.yash.ytdms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.DocumentService;
import com.yash.ytdms.serviceimpl.DocumentServiceImpl;

/**
 * Servlet implementation class HideDocumentController
 */
@WebServlet("/HideDocumentController")
public class HideDocumentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DocumentService documentService = null;
	static final Logger LOGGER = Logger.getLogger(HideDocumentController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HideDocumentController() {
		super();

		documentService = (DocumentService) ObjectFactory.getObject(DocumentService.class);

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int documentfinalId = Integer.parseInt(request.getParameter("id"));
	try {
		documentService.hideDocument(documentfinalId);
		LOGGER.info("Document Sucessfully hide");
		getServletContext().getRequestDispatcher("/ListDocumentController").forward(request, response);
	}catch (Exception e) {
		response.sendRedirect("listDocument.jsp?errMsg=Document is not Hided ");
	}

	}

}
