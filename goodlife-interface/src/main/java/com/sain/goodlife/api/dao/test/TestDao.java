package com.sain.goodlife.api.dao.test;

import com.sain.goodlife.api.dao.BaseDao;
import com.sain.goodlife.api.entity.po.test.TestPoEntity;

public interface TestDao extends BaseDao<Integer, TestPoEntity> {

	public void test();

}
