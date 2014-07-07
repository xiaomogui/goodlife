package com.sain.goodlife.generate.context;

import javax.servlet.ServletContext;

import com.sain.goodlife.generate.configure.Configurable;

public abstract class GenerateContext {

	static String ROOT_WEB_GENERATE_CONTEXT_ATTRIBUTE = GenerateContext.class.getName() + ".ROOT";

	private static Configurable configurable;

	private static ServletContext servletContext;

	public static Configurable getConfigurable() {
		return configurable;
	}

	public static void setConfigurable(Configurable configurable) {
		GenerateContext.configurable = configurable;
	}

	public static ServletContext getServletContext() {
		return servletContext;
	}

	public static void setServletContext(ServletContext servletContext) {
		GenerateContext.servletContext = servletContext;
	}

}
