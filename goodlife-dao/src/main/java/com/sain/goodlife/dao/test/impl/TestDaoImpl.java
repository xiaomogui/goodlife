package com.sain.goodlife.dao.test.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sain.goodlife.api.dao.test.TestDao;
import com.sain.goodlife.api.entity.po.test.TestPoEntity;

@Repository
public class TestDaoImpl implements TestDao {

	@Override
	public void test() {
		System.out.println("dao");
	}

	@Override
	public int insert(TestPoEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(TestPoEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TestPoEntity selectById(Integer pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TestPoEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
