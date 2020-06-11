package com.yash.ytdms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.sun.org.apache.xml.internal.security.encryption.DocumentSerializer;
import com.yash.ytdms.domain.Document;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.DocumentService;

/**
 * Servlet implementation class ShowDocumentController
 */
@WebServlet("/ShowDocumentController")
public class ShowDocumentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DocumentService documentService;
	static final Logger LOGGER = Logger.getLogger(ShowDocumentController.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDocumentController() {
        super();
        documentService = (DocumentService) ObjectFactory.getObject(DocumentService.class);
   
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		int DocumnetId = Integer.parseInt(request.getParameter("id"));
		try {
		Document document = documentService.findDocument(DocumnetId);
		session.setAttribute("document",document);
		LOGGER.info("Document Sucessfully Loaded!");
		response.sendRedirect("viewDocument.jsp");
		}catch (Exception e) {
			response.sendRedirect("listDocument.jsp?errMsg=Cannot load the document ");
		}
		
	}

}
