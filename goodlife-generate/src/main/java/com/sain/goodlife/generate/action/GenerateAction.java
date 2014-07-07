package com.sain.goodlife.generate.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sain.goodlife.generate.po.Tables;
import com.sain.goodlife.generate.service.TableInfoService;

@Controller
@RequestMapping("/generate")
public class GenerateAction {

	@Resource(name = "tableInfoServiceImpl")
	private TableInfoService tableInfoService;

	@RequestMapping(value = "/table/infors", method = RequestMethod.GET)
	public String getTables(Model model){

		List<Tables> tables = tableInfoService.getTables("goodlife");

		model.addAttribute("tables", tables);

		return "index";
	}

}
