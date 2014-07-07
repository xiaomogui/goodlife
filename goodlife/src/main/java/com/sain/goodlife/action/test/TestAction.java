package com.sain.goodlife.action.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sain.goodlife.api.busine3system.test.TestBusiness;

@Controller
@RequestMapping("/test")
public class TestAction {

	@Autowired
	private TestBusiness testBusiness;

	@RequestMapping("/test")
	public String test(){
		testBusiness.test();
		return "/skins/index";
	}

}
