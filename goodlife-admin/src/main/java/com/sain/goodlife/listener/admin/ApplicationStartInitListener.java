package com.sain.goodlife.listener.admin;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Lifecycle Listener implementation class
 * ApplicationStartInitListener
 * 
 */
public final class ApplicationStartInitListener implements
		ServletContextListener {

	private Logger logger = LoggerFactory.getLogger(ApplicationStartInitListener.class);

	/**
	 * Default constructor.
	 */
	public ApplicationStartInitListener() {
		// TODO
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("baseUrl", "/admin");
		logger.info("[Application=" + "] is started in Date[" + new Date(System.currentTimeMillis()) + "]");
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("[Application=" + "] is destroyed in Date[" + new Date(System.currentTimeMillis()) + "]");
	}

}
