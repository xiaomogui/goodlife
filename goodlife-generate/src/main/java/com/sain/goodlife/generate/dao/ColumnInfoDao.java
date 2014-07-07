package com.sain.goodlife.generate.dao;

import java.util.List;

import com.sain.goodlife.generate.po.Columns;

/**
 * 操作information_schema数据库下colums表里的数据的DAO.
 * 接口
 * @author sain
 *
 */
public interface ColumnInfoDao {

	/**
	 * 根据传入的数据库名和表名，从information_schema数据库的colums表里读取字段信息
	 * @param tableSchema 数据库名
	 * @param tableName 表名
	 * @return 数据库表字段的信息集合
	 */
	public List<Columns> getColumns(String tableSchema, String tableName);

}
