package com.sain.goodlife.generate.context;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sain.goodlife.generate.configure.Configurable;
import com.sain.goodlife.io.ResourceUtils;

public class ContextLoader {
	private static final Logger logger = LoggerFactory.getLogger(ContextLoader.class);

	private static final String CONFIG_LOCATION_PARAM = "generateConfigLocation";

	private static final String DEFUALT_CONFIG_LOCATION = "classpath:/config/generate.properties";

	public void initGenerateContext(ServletContext servletContext){

		GenerateContext.setServletContext(servletContext);

		servletContext.setAttribute(GenerateContext.ROOT_WEB_GENERATE_CONTEXT_ATTRIBUTE, GenerateContext.class);

		String location = servletContext.getInitParameter(CONFIG_LOCATION_PARAM);

		Configurable configurable = new Configurable();

		try {
			InputStream is;
			if(location == null || "".equals(location)){
				is = ResourceUtils.getInputStreamForPath(DEFUALT_CONFIG_LOCATION);
			} else {
				is = ResourceUtils.getInputStreamForPath(location);
			}

			configurable.setSettings(is);
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		GenerateContext.setConfigurable(configurable);
		servletContext.setAttribute(Configurable.BASIC_URL, configurable.getBasicUrl());
	}

}
