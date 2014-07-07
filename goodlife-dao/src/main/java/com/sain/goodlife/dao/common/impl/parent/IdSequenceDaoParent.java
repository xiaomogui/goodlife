package com.sain.goodlife.dao.common.impl.parent;

import java.util.List;

import com.sain.goodlife.api.dao.common.IdSequenceDao;
import com.sain.goodlife.api.entity.po.common.IdSequencePoEntity;

public abstract class IdSequenceDaoParent implements IdSequenceDao {

	/**
	 * 对应表名，用于生成主键时使用
	 */
	private static final String TABLE_NAME = "id_sequence";

	/**
	 * 获得表名
	 * @return 表名
	 */
	public static String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public int insert(IdSequencePoEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(IdSequencePoEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IdSequencePoEntity selectById(String pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IdSequencePoEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
