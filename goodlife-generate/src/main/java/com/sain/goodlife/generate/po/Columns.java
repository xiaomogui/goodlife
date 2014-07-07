package com.sain.goodlife.generate.po;

import java.io.Serializable;

public class Columns implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String tableCatalog;

	/**
	 * 所属数据库名
	 */
	private String tableSchema;

	/**
	 * 所属表名
	 */
	private String tableName;

	/**
	 * 列名
	 */
	private String columnName;

	/**
	 * 
	 */
	private String ordinalPosition;

	/**
	 * column的默认值
	 */
	private String columnDefault;

	/**
	 * 是否允许为空
	 */
	private String isNullable;

	/**
	 * 数据类型.
	 * 如：tinyint、int、bigint、double、decimal、varchar、date、time、datetime、binary
	 */
	private String dataType;

	/**
	 * character允许最大长度(根据不同的编码格式，同样的长度所需要的存储空间不同)
	 */
	private String characterMaximamLength;

	/**
	 * character字节(八位bit)长度
	 */
	private String characterOctetLength;

	/**
	 * numeric(数值类型)的精度
	 */
	private String numericPrecision;

	/**
	 * numeric(数值类型)的小数位[此注释待议]
	 */
	private String numericScale;

	/**
	 * 时间类型的精度
	 */
	private String datetimePrecision;

	/**
	 * 编码格式
	 */
	private String characterSetName;

	/**
	 * 编码格式(精确格式)
	 */
	private String collationName;

	/**
	 * cloumn的数据类型.
	 * 例：tinyint(4) unsigned zerofill、decimal(10,0)、varchar(255))
	 */
	private String columnType;

	/**
	 * column键约束(PRI-主键约束，UNI-唯一约束，MUL-外键约束)
	 */
	private String columnKey;

	/**
	 * 扩展(额外)信息，(auto_increment-此字段自增)
	 */
	private String extra;

	/**
	 * 特权(权限)(select,insert,update,references)
	 */
	private String privileges;

	/**
	 * 字段注释
	 */
	private String columnComment;

	public String getTableCatalog() {
		return tableCatalog;
	}

	public void setTableCatalog(String tableCatalog) {
		this.tableCatalog = tableCatalog;
	}

	public String getTableSchema() {
		return tableSchema;
	}

	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getOrdinalPosition() {
		return ordinalPosition;
	}

	public void setOrdinalPosition(String ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}

	public String getColumnDefault() {
		return columnDefault;
	}

	public void setColumnDefault(String columnDefault) {
		this.columnDefault = columnDefault;
	}

	public String getIsNullable() {
		return isNullable;
	}

	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getCharacterMaximamLength() {
		return characterMaximamLength;
	}

	public void setCharacterMaximamLength(String characterMaximamLength) {
		this.characterMaximamLength = characterMaximamLength;
	}

	public String getCharacterOctetLength() {
		return characterOctetLength;
	}

	public void setCharacterOctetLength(String characterOctetLength) {
		this.characterOctetLength = characterOctetLength;
	}

	public String getNumericPrecision() {
		return numericPrecision;
	}

	public void setNumericPrecision(String numericPrecision) {
		this.numericPrecision = numericPrecision;
	}

	public String getNumericScale() {
		return numericScale;
	}

	public void setNumericScale(String numericScale) {
		this.numericScale = numericScale;
	}

	public String getDatetimePrecision() {
		return datetimePrecision;
	}

	public void setDatetimePrecision(String datetimePrecision) {
		this.datetimePrecision = datetimePrecision;
	}

	public String getCharacterSetName() {
		return characterSetName;
	}

	public void setCharacterSetName(String characterSetName) {
		this.characterSetName = characterSetName;
	}

	public String getCollationName() {
		return collationName;
	}

	public void setCollationName(String collationName) {
		this.collationName = collationName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getPrivileges() {
		return privileges;
	}

	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

}
