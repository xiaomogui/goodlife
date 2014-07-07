package com.sain.goodlife.dbutils;

import java.beans.PropertyDescriptor;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;

import org.apache.commons.dbutils.BeanProcessor;

public class DBToBeanProcessor extends BeanProcessor {

	@Override
	protected int[] mapColumnsToProperties(ResultSetMetaData rsmd, PropertyDescriptor[] props) throws SQLException {

		int cols = rsmd.getColumnCount();

		int columnToProperty[] = new int[cols + 1];

		Arrays.fill(columnToProperty, PROPERTY_NOT_FOUND);

		for (int col = 1; col <= cols; col++) {
			String columnName = rsmd.getColumnLabel(col);
			if (null == columnName || 0 == columnName.length()) {
				columnName = rsmd.getColumnName(col);
			}
			for (int i = 0; i < props.length; i++) {
				if (this.match(columnName, props[i].getName())) {// 与BeanProcessor不同的地方
					columnToProperty[col] = i;
					break;
				}
			}
		}

		return columnToProperty;
	}

	private boolean match(String columnName, String propertyName) {
		if (columnName == null){
			return false;
		}

		columnName = columnName.toLowerCase();
		String[] _ary = columnName.split("_");
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < _ary.length; i++) {
			String str = _ary[i];
			if (!"".equals(str) && i > 0) {
				StringBuilder _builder = new StringBuilder();
				str = _builder.append(str.substring(0, 1).toUpperCase())
						.append(str.substring(1)).toString();
			}
			strBuilder.append(str);
		}

		return strBuilder.toString().equals(propertyName);
	}
}
