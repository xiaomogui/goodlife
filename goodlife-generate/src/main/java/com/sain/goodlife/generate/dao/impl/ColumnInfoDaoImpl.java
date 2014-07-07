package com.sain.goodlife.generate.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.sain.goodlife.dbutils.DbUtilsTemplate;
import com.sain.goodlife.generate.dao.ColumnInfoDao;
import com.sain.goodlife.generate.po.Columns;

/**
 * {@inheritDoc}
 * @author sain
 *
 */
@Repository("columnInfoDaoImpl")
public class ColumnInfoDaoImpl implements ColumnInfoDao {

	@Resource(name = "dbUtilsTemplate")
	private DbUtilsTemplate dbUtilsTemplate;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Columns> getColumns(String tableSchema, String tableName) {

		String sql = "SELECT * FROM information_schema.columns WHERE table_schema=? AND table_name=?";

		List<Columns> columnList = dbUtilsTemplate.find(Columns.class, sql, new Object[]{tableSchema, tableName});

		return columnList;
	}

}
