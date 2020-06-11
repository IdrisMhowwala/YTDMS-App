package com.yash.ytdms.controller;
/**
 * This servlet is used to list all the modules present in this app
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.yash.ytdms.domain.PermissionModule;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.PermissionModuleService;

@WebServlet("/ListModuleController")
public class ListModuleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PermissionModuleService permissionModuleService = null;
	static final Logger LOGGER = Logger.getLogger(ListModuleController.class);

	public ListModuleController() {
		super();
		permissionModuleService = (PermissionModuleService) ObjectFactory.getObject(PermissionModuleService.class);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<PermissionModule> modules = permissionModuleService.listAll();
		request.setAttribute("modules", modules);
		getServletContext().getRequestDispatcher("/assignPermission.jsp").forward(request, response);
	}

}
