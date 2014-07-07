package com.sain.goodlife.generate.service;

import java.util.List;

import com.sain.goodlife.generate.po.Tables;

/**
 * 操作information_schema数据库下tables表的service.
 * 接口
 * @author sain
 *
 */
public interface TableInfoService {

	/**
	 * 根据传入的数据库名从information_schema数据库的tables表里读取传入数据库名下的所有表的信息.
	 * @param tableSchema 数据库名
	 * @return 数据库表信息集合
	 */
	public List<Tables> getTables(String tableSchema);

}
