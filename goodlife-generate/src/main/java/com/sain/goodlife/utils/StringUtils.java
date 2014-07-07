package com.sain.goodlife.utils;

public class StringUtils extends org.apache.commons.lang.StringUtils {

	/**
	 * 将数据库字段格式的字符串转换为Java变量格式.
	 * ni_hao -> niHao
	 * @param columnName 传入的字符串(xxx_xxx_xxx)
	 * @return 转换后的字符串(xxxXxxXxx)
	 */
	public static String toJavaParam(String columnName){
		columnName = columnName.toLowerCase();

		String[] _ary = split(columnName, "_");

		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < _ary.length; i++) {
			String str = _ary[i];
			if (!"".equals(str) && i > 0) {
				StringBuilder _builder = new StringBuilder();
				str = _builder.append(str.substring(0, 1).toUpperCase()).append(str.substring(1)).toString();
			}
			strBuilder.append(str);
		}

		return strBuilder.toString();
	}

	/**
	 * Returns the input argument, but ensures the first character is capitalized (if possible).
	 * @param in the string to uppercase the first character.
	 * @return the input argument, but with the first character capitalized (if possible).
	 * @since 1.2
	 */
	public static String uppercaseFirstChar(String in) {
		if (in == null || in.length() == 0) {
			return in;
		}
		int length = in.length();
		StringBuilder sb = new StringBuilder(length);

		sb.append(Character.toUpperCase(in.charAt(0)));
		if (length > 1) {
			String remaining = in.substring(1);
			sb.append(remaining);
		}
		return sb.toString();
	}

}
