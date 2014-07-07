package com.sain.goodlife.generate.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sain.goodlife.generate.po.Tables;
import com.sain.goodlife.generate.service.GenerateExcelService;
import com.sain.goodlife.generate.service.TableInfoService;

@Controller
@RequestMapping(value="/gExcel")
public class GenerateExcelAction {

	@Resource(name = "tableInfoServiceImpl")
	private TableInfoService tableInfoService;
	@Resource(name = "generateExcelServiceImpl")
	private GenerateExcelService generateExcelService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getTables(Model model){

		List<Tables> tables = tableInfoService.getTables("goodlife");

		model.addAttribute("tables", tables);

		return "gExcel/index";
	}

	@RequestMapping(value = "/generate", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> generate(String tableNames, Model model){
		Map<String, Object> jsonMap = new HashMap<String, Object>();

		boolean result = generateExcelService.generate(tableNames);

		if(result){
			// 生成状态(1-成功, 2-失败)
			jsonMap.put("result", "1");
		} else {
			// 生成状态(1-成功, 2-失败)
			jsonMap.put("result", "2");
		}

		return jsonMap;
	}

}
