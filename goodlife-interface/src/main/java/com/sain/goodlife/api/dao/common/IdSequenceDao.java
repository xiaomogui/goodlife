package com.sain.goodlife.api.dao.common;

import com.sain.goodlife.api.dao.BaseDao;
import com.sain.goodlife.api.entity.po.common.IdSequencePoEntity;

/**
 * 主键生成表DAO接口
 * @author sain
 *
 */
public interface IdSequenceDao extends BaseDao<String, IdSequencePoEntity> {

	/**
	 * 根据传入的表名得到此表的下一个ID主键值
	 * @param tableName 表名
	 * @return 传入表名的下一个ID主键
	 */
	public long getNextVal(String tableName);

}
