package com.sain.goodlife.generate.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sain.goodlife.generate.core.constant.SqlConstant;
import com.sain.goodlife.generate.core.entity.GExcelSqlEntity;
import com.sain.goodlife.generate.po.Columns;

/**
 * 生成常用sql.
 * @author sain
 *
 */
public class GSql {

	private static GSql gSql = new GSql();

	/**
	 * 在sql语句中使用此前缀标识变量，默认为":".
	 */
	public static final String VAR_PREFIX = ":";
	/**
	 * TODO
	 * 在sql语句中使用此后缀标识变量，与VAR_PREFIX配合使用，默认为"".
	 */
	public static final String VAR_Suffix = "";

	private GSql(){
		
	}

	/**
	 * 获取GSql实例.
	 * @return
	 */
	public static GSql getInstance(){
		return gSql;
	}

	/**
	 * 得到sql实例集合.
	 * @param tableName 表名
	 * @param columnList 字段集合
	 */
	public List<GExcelSqlEntity> getSqlEntitys(final String tableName, final List<Columns> columnList){
		List<GExcelSqlEntity> gExcelSqlEntities = new ArrayList<GExcelSqlEntity>();

		gExcelSqlEntities.add(getInsertSqlEntity(tableName, columnList));
		gExcelSqlEntities.add(getDeleteByIdSqlEntity(tableName, columnList));
		gExcelSqlEntities.add(getUpdateByIdSqlEntity(tableName, columnList));
		gExcelSqlEntities.add(getSelectByIdSqlEntity(tableName, columnList));
		gExcelSqlEntities.add(getSelectAllSqlEntity(tableName));

		return gExcelSqlEntities;
	}

	/**
	 * 生成[插入数据]的sql实例.
	 * @param tableName 表名
	 * @param columnList 字段集合
	 * @return
	 */
	public GExcelSqlEntity getInsertSqlEntity(final String tableName, final List<Columns> columnList){
		GExcelSqlEntity insertSql = new GExcelSqlEntity();

		String sqlName = tableName + "." + SqlConstant.SQL_NAME_INSERT;

		StringBuilder sqlKeys = new StringBuilder();
		StringBuilder sqlValues = new StringBuilder();
		for(int i = 0, size = columnList.size(); i < size; i++){
			Columns column = columnList.get(i);
			String columnName = column.getColumnName();

			sqlKeys.append(columnName);

			sqlValues.append(VAR_PREFIX);
			sqlValues.append(columnName);

			if (i != size - 1) {
				sqlKeys.append(",");

				sqlValues.append(",");
			}
		}

		insertSql.setName(sqlName);
		insertSql.setType(SqlConstant.TYPE_INSERT);
		insertSql.setSql(String.format(SqlConstant.SQL_TEMPLATE_INSERT, tableName, sqlKeys.toString(), sqlValues.toString()));
		insertSql.setResult(int.class.getSimpleName());

		return insertSql;
	}

	/**
	 * 生成[根据主键删除数据]的sql实例.
	 * @param tableName 表名
	 * @param columnList 字段集合
	 * @return
	 */
	public GExcelSqlEntity getDeleteByIdSqlEntity(final String tableName, final List<Columns> columnList){
		GExcelSqlEntity insertSql = new GExcelSqlEntity();

		String sqlName = tableName + "." + SqlConstant.SQL_NAME_DELETE_BY_ID;

		StringBuilder sqlWheres = new StringBuilder();
		for(int i = 0, size = columnList.size(); i < size; i++){
			Columns column = columnList.get(i);
			String columnName = column.getColumnName();
			String columnKey = column.getColumnKey();

			if(StringUtils.isNotEmpty(columnKey) && "PRI".equals(columnKey)){
				sqlWheres.append(columnName);
				sqlWheres.append("=");
				sqlWheres.append(VAR_PREFIX);
				sqlWheres.append(columnName);
				sqlWheres.append(" AND ");
			}
		}
		sqlWheres.append("1=1");

		insertSql.setName(sqlName);
		insertSql.setType(SqlConstant.TYPE_DELETE);
		insertSql.setSql(String.format(SqlConstant.SQL_TEMPLATE_DELETE_BY_ID, tableName, sqlWheres.toString()));
		insertSql.setResult(int.class.getSimpleName());

		return insertSql;
	}

	/**
	 * 生成[根据主键更新数据]的sql实例.
	 * @param tableName 表名
	 * @param columnList 字段集合
	 * @return
	 */
	public GExcelSqlEntity getUpdateByIdSqlEntity(final String tableName, final List<Columns> columnList){
		GExcelSqlEntity insertSql = new GExcelSqlEntity();

		String sqlName = tableName + "." + SqlConstant.SQL_NAME_UPDATE_BY_ID;

		List<Columns> othColumnList = new ArrayList<Columns>();
		List<Columns> priColumnList = new ArrayList<Columns>();
		for(int i = 0, size = columnList.size(); i < size; i++){
			Columns column = columnList.get(i);
			String columnKey = column.getColumnKey();
			if(StringUtils.isNotEmpty(columnKey) && "PRI".equals(columnKey)){
				priColumnList.add(column);
			} else {
				othColumnList.add(column);
			}
		}

		StringBuilder sqlSets = new StringBuilder();
		for(int i = 0, size = othColumnList.size(); i < size; i++){
			Columns column = othColumnList.get(i);
			sqlSets.append(column.getColumnName());
			sqlSets.append("=");
			sqlSets.append(VAR_PREFIX);
			sqlSets.append(column.getColumnName());
			if(i != size -1){
				sqlSets.append(", ");
			}
		}

		StringBuilder sqlWheres = new StringBuilder();
		for(int i = 0, size = priColumnList.size(); i < size; i++){
			Columns column = priColumnList.get(i);
			sqlWheres.append(column.getColumnName());
			sqlWheres.append("=");
			sqlWheres.append(VAR_PREFIX);
			sqlWheres.append(column.getColumnName());
			if(i != size -1){
				sqlWheres.append(" AND ");
			}
		}

		insertSql.setName(sqlName);
		insertSql.setType(SqlConstant.TYPE_UPDATE);
		insertSql.setSql(String.format(SqlConstant.SQL_TEMPLATE_UPDATE_BY_ID, tableName, sqlSets.toString(), sqlWheres.toString()));
		insertSql.setResult(int.class.getSimpleName());

		return insertSql;
	}

	/**
	 * 生成[根据主键查询数据]的sql实例.
	 * @param tableName 表名
	 * @param columnList 字段集合
	 * @return
	 */
	public GExcelSqlEntity getSelectByIdSqlEntity(final String tableName, final List<Columns> columnList){
		GExcelSqlEntity insertSql = new GExcelSqlEntity();

		String sqlName = tableName + "." + SqlConstant.SQL_NAME_SELECT_BY_ID;

		List<Columns> priColumnList = new ArrayList<Columns>();
		for(int i = 0, size = columnList.size(); i < size; i++){
			Columns column = columnList.get(i);
			String columnKey = column.getColumnKey();
			if(StringUtils.isNotEmpty(columnKey) && "PRI".equals(columnKey)){
				priColumnList.add(column);
			}
		}

		StringBuilder sqlWheres = new StringBuilder();
		for(int i = 0, size = priColumnList.size(); i < size; i++){
			Columns column = priColumnList.get(i);
			sqlWheres.append(column.getColumnName());
			sqlWheres.append("=");
			sqlWheres.append(VAR_PREFIX);
			sqlWheres.append(column.getColumnName());
			if(i != size -1){
				sqlWheres.append(" AND ");
			}
		}

		insertSql.setName(sqlName);
		insertSql.setType(SqlConstant.TYPE_SELECT);
		insertSql.setSql(String.format(SqlConstant.SQL_TEMPLATE_SELECT_BY_ID, "*", tableName, sqlWheres.toString()));

		return insertSql;
	}

	/**
	 * 生成[查询所有数据]的sql实例.
	 * @param tableName 表名
	 * @param columnList 字段集合
	 * @return
	 */
	public GExcelSqlEntity getSelectAllSqlEntity(final String tableName){
		GExcelSqlEntity insertSql = new GExcelSqlEntity();

		String sqlName = tableName + "." + SqlConstant.SQL_NAME_SELECT_ALL;

		insertSql.setName(sqlName);
		insertSql.setType(SqlConstant.TYPE_SELECT);
		insertSql.setSql(String.format(SqlConstant.SQL_TEMPLATE_SELECT_ALL, "*", tableName));

		return insertSql;
	}

}
