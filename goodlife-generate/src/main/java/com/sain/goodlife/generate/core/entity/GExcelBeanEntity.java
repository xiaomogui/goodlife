package com.sain.goodlife.generate.core.entity;

public class GExcelBeanEntity {

	/**
	 * bean名称.
	 */
	private String beanName;

	/**
	 * 类名名.
	 */
	private String beanClassName;

	/**
	 * 包路径.
	 */
	private String packageName;

	/**
	 * 域(VO、DTO、DO、PO).
	 */
	private String domain;

	/**
	 * 类型(IN、OUT).
	 */
	private String type;

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getBeanClassName() {
		return beanClassName;
	}

	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
