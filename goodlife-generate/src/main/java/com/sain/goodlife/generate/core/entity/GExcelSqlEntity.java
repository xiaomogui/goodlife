package com.sain.goodlife.generate.core.entity;

/**
 * 可执行sql实体类
 * @author sain
 *
 */
public class GExcelSqlEntity {

	/**
	 * sql标识名称
	 */
	private String name;

	/**
	 * sql语句
	 */
	private String sql;

	/**
	 * 操作类型(1-增,2-删,3-改,4-查)
	 */
	private String type;

	/**
	 * 返回值类型
	 */
	private String result;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
