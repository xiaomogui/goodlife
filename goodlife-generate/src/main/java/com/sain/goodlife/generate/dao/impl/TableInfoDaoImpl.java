package com.sain.goodlife.generate.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.sain.goodlife.dbutils.DbUtilsTemplate;
import com.sain.goodlife.generate.dao.TableInfoDao;
import com.sain.goodlife.generate.po.Tables;

/**
 * {@inheritDoc}
 * @author sain
 *
 */
@Repository("tableInfoDaoImpl")
public class TableInfoDaoImpl implements TableInfoDao {

	@Resource(name = "dbUtilsTemplate")
	private DbUtilsTemplate dbUtilsTemplate;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Tables> getTables(String tableSchema) {
		String sql = "SELECT * FROM information_schema.tables WHERE table_schema=?";

		List<Tables> tableList = dbUtilsTemplate.find(Tables.class, sql, tableSchema);

		return tableList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Tables getTableInfoByTableName(String tableSchema, String tableName) {
		String sql = "SELECT * FROM information_schema.tables WHERE table_schema=? AND table_name=?";

		Tables table = dbUtilsTemplate.findFirst(Tables.class, sql, new Object[]{tableSchema, tableName});

		return table;
	}

}
