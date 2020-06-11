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
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.DocumentService;
import com.yash.ytdms.service.TestService;
import com.yash.ytdms.serviceimpl.DocumentServiceImpl;

/**
 * Servlet implementation class DisableDocument
 */
@WebServlet("/DisableDocumentController")
public class DisableDocumentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(DisableDocumentController.class);
	private DocumentService documentService ; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisableDocumentController() {
        super();
      
        documentService = (DocumentService) ObjectFactory.getObject(DocumentService.class);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int disableId=Integer.parseInt(request.getParameter("id"));
		try {
		documentService.disableStatus(disableId);
		LOGGER.info("Document List disable status updated Successfully");
		getServletContext().getRequestDispatcher("/ListDocumentController").forward(request, response);
		}catch (Exception e) {
			response.sendRedirect("listDocument.jsp?errMsg=Document is not Disabled ");
		}
	}

}
