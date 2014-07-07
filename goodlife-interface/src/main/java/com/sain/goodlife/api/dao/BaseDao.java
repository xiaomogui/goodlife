package com.sain.goodlife.api.dao;

import java.util.List;

import com.sain.goodlife.api.entity.po.PoEntity;

/**
 * 基础DAO接口
 * @author sain
 *
 * @param <PK> 主键
 * @param <ENTITY> 数据库实体类
 */
public interface BaseDao<PK, ENTITY extends PoEntity> {

	/**
	 * 将传入的实体数据插入到数据库
	 * @param entity
	 * @return
	 */
	public int insert(ENTITY entity);

	/**
	 * 根据传入的ID删除相应的数据记录
	 * @param id
	 * @return
	 */
	public int deleteById(PK pk);

	/**
	 * 根据传入的实体数据更新数据记录
	 * @param entity
	 * @return
	 */
	public int update(ENTITY entity);

	/**
	 * 根据传入的ID查询相应的数据记录
	 * @param id
	 * @return
	 */
	public ENTITY selectById(PK pk);

	/**
	 * 查询所有的数据记录
	 * @return
	 */
	public List<ENTITY> findAll();

}
