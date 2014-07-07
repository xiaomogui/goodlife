package com.sain.goodlife.basicservice.test.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sain.goodlife.api.basicservice.test.TestBasicService;
import com.sain.goodlife.api.dao.test.TestDao;

@Service
public class TestBasicServiceImpl implements TestBasicService {

	@Autowired
	private TestDao testDao;

	@Override
	public void test() {
		System.out.println("doit");
		testDao.test();
	}

}
