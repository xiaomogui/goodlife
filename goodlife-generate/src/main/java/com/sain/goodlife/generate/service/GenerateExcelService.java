package com.sain.goodlife.generate.service;

/**
 * 产生excel配置file的相关操作
 * @author sain
 *
 */
public interface GenerateExcelService {

	/**
	 * 根据传入的表名集合，产生对应的excel配置.
	 * @param tableNames 以,拼接的表名集合字符串
	 * @return
	 */
	public boolean generate(String tableNames);

}
