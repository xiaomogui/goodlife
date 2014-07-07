package com.sain.goodlife.generate.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sain.goodlife.generate.context.GenerateContext;
import com.sain.goodlife.generate.core.GExcel;
import com.sain.goodlife.generate.dao.ColumnInfoDao;
import com.sain.goodlife.generate.dao.TableInfoDao;
import com.sain.goodlife.generate.po.Columns;
import com.sain.goodlife.generate.po.Tables;
import com.sain.goodlife.generate.service.GenerateExcelService;

/**
 * {@inheritDoc}
 * @author sain
 *
 */
@Service("generateExcelServiceImpl")
public class GenerateExcelServiceImpl implements GenerateExcelService {

	@Resource(name = "tableInfoDaoImpl")
	private TableInfoDao tableInfoDao;
	@Resource(name = "columnInfoDaoImpl")
	private ColumnInfoDao columnInfoDao;

	private final String tableSchema = GenerateContext.getConfigurable().getTableSchema();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean generate(String tableNames) {
		boolean flag = false;

		// 得到表名数组
		String[] tableNameArr = StringUtils.split(tableNames, ",");

		// 要生成excel配置的对应表信息集合
		List<Tables> tableList = getIablesInfo(tableNameArr);

		// 循环生成excel配置
		if(!CollectionUtils.isEmpty(tableList)){
			for(int i = 0, size = tableList.size(); i < size; i++){
				Tables table = tableList.get(i);
				// 生成excel配置
				flag = generateExcelFile(table);

				// 如果有一个生成错误，停止
				if(!flag){
					break;
				}
			}
		}

		return flag;
	}

	/**
	 * 根据传入的表名数组查询对应表信息
	 * @param tableNameArr 表名数组
	 * @return 表信息集合
	 */
	private List<Tables> getIablesInfo(String[] tableNameArr){
		List<Tables> tableList = new ArrayList<Tables>();

		if(tableNameArr != null){
			for(int i = 0, length = tableNameArr.length; i < length; i++){
				String tableName = tableNameArr[i];

				Tables table = tableInfoDao.getTableInfoByTableName(tableSchema, tableName);
				List<Columns> columnList = columnInfoDao.getColumns(tableSchema, tableName);
				table.setColumns(columnList);

				tableList.add(table);
			}
		}

		return tableList;
	}

	/**
	 * 根据传入的table信息生成对应的excel配置
	 * @param table
	 * @return
	 */
	private boolean generateExcelFile(Tables table){
		boolean flag = false;

		flag = GExcel.getInstance().createExcelCnfFile(table);

		return flag;
	}
}
