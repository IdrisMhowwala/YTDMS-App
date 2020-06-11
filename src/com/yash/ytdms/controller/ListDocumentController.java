package com.yash.ytdms.controller;

import java.io.IOException;
import java.util.ArrayList;
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

/**
 * Servlet implementation class ListDocumentController
 */
@WebServlet("/ListDocumentController")
public class ListDocumentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(ListDocumentController.class);
	private DocumentService documentService;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListDocumentController() {
        super();
        documentService = (DocumentService) ObjectFactory.getObject(DocumentService.class);
        }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		List<Document> documents = new ArrayList<>();
		int sectionId ;
		if((request.getParameter("sectionId")!=null)) {
			sectionId = Integer.parseInt(request.getParameter("sectionId"));	
			session.setAttribute("sectionId",sectionId);
			int categoryId =  (int) session.getAttribute("categoryId");
		}
		else {
			sectionId= (int) session.getAttribute("sectionId");
		}
//		int sectionId=6;
		try {
		
		documents = documentService.searchBySectionId(sectionId);
		LOGGER.info("Document List Loaded Sucessfully");
		session.setAttribute("documents", documents);
		response.sendRedirect("listDocument.jsp");
		}catch (Exception e) {
			LOGGER.info("Document List Not Found");
			response.sendRedirect("sectionList.jsp?errMsg=Cannot Load Document List ");
		}
	}

}
