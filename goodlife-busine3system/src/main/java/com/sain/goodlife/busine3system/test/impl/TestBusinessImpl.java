package com.sain.goodlife.busine3system.test.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sain.goodlife.api.busine3system.test.TestBusiness;
import com.sain.goodlife.api.coreservice.test.TestCoreService;

@Service
public class TestBusinessImpl implements TestBusiness {

	@Autowired
	private TestCoreService testCoreService;

	@Override
	public void test() {
		System.out.println("test");
		testCoreService.test();
	}

}
