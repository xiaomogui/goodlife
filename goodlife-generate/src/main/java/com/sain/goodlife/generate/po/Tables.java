package com.sain.goodlife.generate.po;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * information_schema数据库下tables表的实体类.
 * 
 * @author sain
 * 
 */
public class Tables implements Serializable {

	/**
	 * 版本1
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
	 * 表名
	 */
	private String tableName;

	/**
	 * 表类型
	 */
	private String tableType;

	/**
	 * 数据库引擎类型
	 */
	private String engine;

	/**
	 * 版本
	 */
	private long version;

	/**
	 * 
	 */
	private String rowFormat;

	/**
	 * 当前有几行数据
	 */
	private long tableRows;

	/**
	 * 平均每行数的的大小
	 */
	private long avgRowLength;

	/**
	 * 
	 */
	private long dataLength;

	/**
	 * 
	 */
	private long maxDataLength;

	/**
	 * 
	 */
	private long indexLength;

	/**
	 * 
	 */
	private long dataFree;

	/**
	 * 自增变量的下一个值
	 */
	private long autoIncrement;

	/**
	 * 创建时间
	 */
	private Timestamp createTime;

	/**
	 * 更新时间
	 */
	private Timestamp updateTime;

	/**
	 * 
	 */
	private Timestamp checkTime;

	/**
	 * 表的编码格式
	 */
	private String tableCollation;

	/**
	 * 
	 */
	private long checksum;

	/**
	 * 
	 */
	private String createOptions;

	/**
	 * 表的注释
	 */
	private String tableComment;

	/**
	 * 此表的字段信息集合
	 */
	private List<Columns> columns;

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

	public String getTableType() {
		return tableType;
	}

	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getRowFormat() {
		return rowFormat;
	}

	public void setRowFormat(String rowFormat) {
		this.rowFormat = rowFormat;
	}

	public long getTableRows() {
		return tableRows;
	}

	public void setTableRows(long tableRows) {
		this.tableRows = tableRows;
	}

	public long getAvgRowLength() {
		return avgRowLength;
	}

	public void setAvgRowLength(long avgRowLength) {
		this.avgRowLength = avgRowLength;
	}

	public long getDataLength() {
		return dataLength;
	}

	public void setDataLength(long dataLength) {
		this.dataLength = dataLength;
	}

	public long getMaxDataLength() {
		return maxDataLength;
	}

	public void setMaxDataLength(long maxDataLength) {
		this.maxDataLength = maxDataLength;
	}

	public long getIndexLength() {
		return indexLength;
	}

	public void setIndexLength(long indexLength) {
		this.indexLength = indexLength;
	}

	public long getDataFree() {
		return dataFree;
	}

	public void setDataFree(long dataFree) {
		this.dataFree = dataFree;
	}

	public long getAutoIncrement() {
		return autoIncrement;
	}

	public void setAutoIncrement(long autoIncrement) {
		this.autoIncrement = autoIncrement;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Timestamp getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}

	public String getTableCollation() {
		return tableCollation;
	}

	public void setTableCollation(String tableCollation) {
		this.tableCollation = tableCollation;
	}

	public long getChecksum() {
		return checksum;
	}

	public void setChecksum(long checksum) {
		this.checksum = checksum;
	}

	public String getCreateOptions() {
		return createOptions;
	}

	public void setCreateOptions(String createOptions) {
		this.createOptions = createOptions;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public List<Columns> getColumns() {
		return columns;
	}

	public void setColumns(List<Columns> columns) {
		this.columns = columns;
	}

}
