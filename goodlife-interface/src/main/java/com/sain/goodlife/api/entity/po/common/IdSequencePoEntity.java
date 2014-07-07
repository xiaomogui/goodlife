package com.sain.goodlife.api.entity.po.common;

import com.sain.goodlife.api.entity.po.PoEntity;

// Generated 2014-5-27 15:50:26 by Hibernate Tools 4.0.0

/**
 * IdSequence generated by hbm2java
 */
public class IdSequencePoEntity implements PoEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tableName;
	private String version;
	private long nextVal;
	private byte increment;

	public IdSequencePoEntity() {
	}

	public IdSequencePoEntity(String tableName, long nextVal, byte increment) {
		this.tableName = tableName;
		this.nextVal = nextVal;
		this.increment = increment;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public long getNextVal() {
		return this.nextVal;
	}

	public void setNextVal(long nextVal) {
		this.nextVal = nextVal;
	}

	public byte getIncrement() {
		return this.increment;
	}

	public void setIncrement(byte increment) {
		this.increment = increment;
	}

}
