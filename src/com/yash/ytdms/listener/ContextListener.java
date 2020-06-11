package com.yash.ytdms.listener;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.PropertyConfigurator;

@WebListener("application context listener")
public class ContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// do not add any code here

	}

	/**
     * Initialize log4j when the application is being started
     */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext =sce.getServletContext();
		String log4jConfigFile =servletContext.getInitParameter("log4j-config-location");
		String fullPath = servletContext.getRealPath("")+File.separator+log4jConfigFile;
		PropertyConfigurator.configure(fullPath);

	}

}
