package com.sain.goodlife.generate.core.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据库操作类型及常用sql模板
 * @author ddtt
 *
 */
public class SqlConstant {

	/**
	 * sql操作类型-插入.
	 */
	public static final String TYPE_INSERT = "insert";

	/**
	 * sql操作类型-删除.
	 */
	public static final String TYPE_DELETE = "delete";

	/**
	 * sql操作类型-更新.
	 */
	public static final String TYPE_UPDATE = "update";

	/**
	 * sql操作类型-更新.
	 */
	public static final String TYPE_SELECT = "select";

	/**
	 * sql名称-插入数据.
	 */
	public static final String SQL_NAME_INSERT = "insert";

	/**
	 * 常用sql模板-插入数据.
	 * INSERT INTO ${table_name}(${column1,column2,column3}) VALUES(${val1,val2,val3});
	 */
	public static final String SQL_TEMPLATE_INSERT = "INSERT INTO %s(%s) VALUES(%s);";

	/**
	 * sql名称-删除数据.
	 */
	public static final String SQL_NAME_DELETE_BY_ID = "deleteById";

	/**
	 * 常用sql模板-删除数据.
	 * DELETE FROM ${table_name} WHERE ${column1=val1 AND column2=val2};
	 */
	public static final String SQL_TEMPLATE_DELETE_BY_ID = "DELETE FROM %s WHERE %s;";

	/**
	 * sql名称-更新数据.
	 */
	public static final String SQL_NAME_UPDATE_BY_ID = "updateById";

	/**
	 * 常用sql模板-更新数据.
	 * UPDATE ${table_name} SET ${column1=val1, column2=val2} WHERE ${column3=val3 AND column4=val4};
	 */
	public static final String SQL_TEMPLATE_UPDATE_BY_ID = "UPDATE %s SET %s WHERE %s;";

	/**
	 * sql名称-查询数据.
	 */
	public static final String SQL_NAME_SELECT_BY_ID = "selectById";

	/**
	 * 常用sql模板-查询数据.
	 * SELECT ${column1,column2,column3} FROM ${table_name} WHERE ${column1=val1 AND column2=val2};
	 */
	public static final String SQL_TEMPLATE_SELECT_BY_ID = "SELECT %s FROM %s WHERE %s;";

	/**
	 * sql名称-查询所有数据.
	 */
	public static final String SQL_NAME_SELECT_ALL = "selectAll";

	/**
	 * 常用sql模板-查询所有数据.
	 * SELECT ${column1,column2,column3} FROM ${table_name};
	 */
	public static final String SQL_TEMPLATE_SELECT_ALL = "SELECT %s FROM %s;";

	/**
	 * sql语句模板映射.
	 */
	@SuppressWarnings("serial")
	public static final Map<String, String> SQL_TEMPLATE_MAP = new HashMap<String, String>(){
		{
			put(SQL_NAME_INSERT, SQL_TEMPLATE_INSERT);
			put(SQL_NAME_DELETE_BY_ID, SQL_TEMPLATE_DELETE_BY_ID);
			put(SQL_NAME_UPDATE_BY_ID, SQL_TEMPLATE_UPDATE_BY_ID);
			put(SQL_NAME_SELECT_BY_ID, SQL_TEMPLATE_SELECT_BY_ID);
			put(SQL_NAME_SELECT_ALL, SQL_TEMPLATE_SELECT_ALL);
		}
	};

}
