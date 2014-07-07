package com.sain.goodlife.generate.core.entity;

import java.util.List;

public class GExcelEntity {

	// JavaBean里用到的所有字段信息
	private List<GExcelBeanParameterEntity> gExcelBeanParameterEntities;

	// 记录所有Bean信息(xxxInPO,xxxOutDto,xxxInVo,...)
	private List<GExcelBeanEntity> gExcelBeanEntities;

	// excel里的配置sql集合
	private List<GExcelSqlEntity> gExcelSqlEntities;

	public List<GExcelBeanParameterEntity> getgExcelBeanParameterEntities() {
		return gExcelBeanParameterEntities;
	}

	public void setgExcelBeanParameterEntities(
			List<GExcelBeanParameterEntity> gExcelBeanParameterEntities) {
		this.gExcelBeanParameterEntities = gExcelBeanParameterEntities;
	}

	public List<GExcelBeanEntity> getgExcelBeanEntities() {
		return gExcelBeanEntities;
	}

	public void setgExcelBeanEntities(List<GExcelBeanEntity> gExcelBeanEntities) {
		this.gExcelBeanEntities = gExcelBeanEntities;
	}

	public List<GExcelSqlEntity> getgExcelSqlEntities() {
		return gExcelSqlEntities;
	}

	public void setgExcelSqlEntities(List<GExcelSqlEntity> gExcelSqlEntities) {
		this.gExcelSqlEntities = gExcelSqlEntities;
	}

}
