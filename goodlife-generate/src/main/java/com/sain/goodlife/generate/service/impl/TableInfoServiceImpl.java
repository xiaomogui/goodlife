package com.sain.goodlife.generate.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sain.goodlife.generate.dao.TableInfoDao;
import com.sain.goodlife.generate.po.Tables;
import com.sain.goodlife.generate.service.TableInfoService;

/**
 * {@inheritDoc}
 * @author sain
 *
 */
@Service("tableInfoServiceImpl")
public class TableInfoServiceImpl implements TableInfoService {

	@Resource(name = "tableInfoDaoImpl")
	private TableInfoDao tableInfoDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Tables> getTables(String tableSchema) {
		return tableInfoDao.getTables(tableSchema);
	}

}
