package com.sain.goodlife.coreservice.test.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sain.goodlife.api.basicservice.test.TestBasicService;
import com.sain.goodlife.api.coreservice.test.TestCoreService;

@Service
public class TestCoreServiceImpl implements TestCoreService {

	@Autowired
	private TestBasicService testBasicService;

	@Override
	public void test() {
		System.out.println("logic");
		testBasicService.test();
	}

}
