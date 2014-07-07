package com.sain.goodlife.generate.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sain.goodlife.generate.context.ContextLoader;

/**
 * Application Lifecycle Listener implementation class GenerateApplicationInitListener
 *
 */
public class GenerateApplicationInitListener extends ContextLoader implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		initGenerateContext(sce.getServletContext());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

}
