package com.sain.goodlife.generate.configure;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;

public class Configurable {

	public static final String TABLE_SCHEMA_KEY = "table_schema";
	public static final String CHARACTER_KEY = "character";
	public static final String BASIC_URL = "basic_url";
	public static final String BASIC_PACKAGE = "basic_package";

	private Properties properties;
	private HashMap<Object, Object> customAttributes;

	/**
	 * 数据库名
	 */
	private String tableSchema;
	/**
	 * 编码格式
	 */
	private String character;
	/**
	 * 应用基础url
	 */
	private String basicUrl;
	/**
	 * 应用基础url
	 */
	private String basicPackage;

	public Configurable() {
		tableSchema = "test";
		character = "UTF-8";
		basicUrl = "/generate";
		basicPackage = "com.sain.goodlife";

		properties = new Properties();
		properties.setProperty(TABLE_SCHEMA_KEY, tableSchema);
		properties.setProperty(CHARACTER_KEY, character);
		properties.setProperty(BASIC_URL, basicUrl);
		properties.setProperty(BASIC_PACKAGE, basicPackage);

		customAttributes = new HashMap<Object, Object>();
	}

	public String getTableSchema() {
		return tableSchema;
	}

	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
		properties.setProperty(TABLE_SCHEMA_KEY, tableSchema);
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
		properties.setProperty(CHARACTER_KEY, character);
	}

	public String getBasicUrl() {
		return basicUrl;
	}

	public void setBasicUrl(String basicUrl) {
		this.basicUrl = basicUrl;
		properties.setProperty(BASIC_URL, basicUrl);
	}

	public String getBasicPackage() {
		return basicPackage;
	}

	public void setBasicPackage(String basicPackage) {
		this.basicPackage = basicPackage;
		properties.setProperty(BASIC_PACKAGE, basicPackage);
	}

	public String getSetting(String key) {
		return properties.getProperty(key);
	}

	public void setSetting(String name, String value) {
		if (TABLE_SCHEMA_KEY.equals(name)) {
			setTableSchema(value);
		} else if (CHARACTER_KEY.equals(name)) {
			setCharacter(value);
		}
	}

	public Map<?, ?> getSettings() {
		return Collections.unmodifiableMap(properties);
	}

	public void setSettings(Properties props) {
		Iterator<?> it = props.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			setSetting(key, props.getProperty(key).trim());
		}
	}

	public void setSettings(InputStream propsIn) throws IOException {
		Properties p = new Properties();
		p.load(propsIn);
		setSettings(p);
	}

	public void setCustomAttribute(String name, Object value) {
		synchronized (customAttributes) {
			customAttributes.put(name, value);
		}
	}

	public Object getCustomAttribute(String name) {
		Object retval;
		synchronized (customAttributes) {
			retval = customAttributes.get(name);
			if (retval == null && customAttributes.containsKey(name)) {
				return null;
			}
		}
		return retval;
	}

	public String[] getCustomAttributeNames() {
		synchronized (customAttributes) {
			Collection<Object> names = new LinkedList<Object>(customAttributes.keySet());
			for (Iterator<Object> iter = names.iterator(); iter.hasNext();) {
				if (!(iter.next() instanceof String)) {
					iter.remove();
				}
			}
			return (String[]) names.toArray(new String[names.size()]);
		}
	}

	public void removeCustomAttribute(String name) {
		synchronized (customAttributes) {
			customAttributes.remove(name);
		}
	}

}
