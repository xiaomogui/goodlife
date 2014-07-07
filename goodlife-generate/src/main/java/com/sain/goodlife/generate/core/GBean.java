package com.sain.goodlife.generate.core;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sain.goodlife.generate.context.GenerateContext;
import com.sain.goodlife.generate.core.constant.SqlConstant;
import com.sain.goodlife.generate.core.entity.GExcelBeanEntity;
import com.sain.goodlife.generate.core.entity.GExcelBeanParameterEntity;
import com.sain.goodlife.generate.po.Columns;
import com.sain.goodlife.generate.po.Tables;
import com.sain.goodlife.utils.StringUtils;

public class GBean {

	private static GBean gBean = new GBean();

	/**
	 * mysql与java类型之间的映射关系
	 */
	@SuppressWarnings("serial")
	public static final Map<String, String> SQL_TYPE_MAPPING = new HashMap<String, String>(){
		{
			put("tinyint", short.class.getName());
			put("smallint", short.class.getName());
			put("mediumint", int.class.getName());
			put("int", int.class.getName());
			put("integer", Integer.class.getName());// integer与int等同
			put("bigint", long.class.getName());
			put("bit", byte.class.getName());
			put("real", double.class.getName());// real与double等同
			put("double", double.class.getName());
			put("float", float.class.getName());
			put("decimal", BigDecimal.class.getName());
			put("numeric", BigDecimal.class.getName());// numeric与decimal等同
			put("char", String.class.getName());
			put("varchar", String.class.getName());
			put("date", Date.class.getName());
			put("time", Time.class.getName());
			put("year", Date.class.getName());
			put("timestamp", Timestamp.class.getName());
			put("datetime", Timestamp.class.getName());
			put("tinyblob", String.class.getName());
			put("blob", String.class.getName());
			put("mediumblob", String.class.getName());
			put("longblob", String.class.getName());
			put("tinytext", String.class.getName());
			put("text", String.class.getName());
			put("mediumtext", String.class.getName());
			put("longtext", String.class.getName());
			put("enum", String.class.getName());
			put("set", Set.class.getName());
			put("binary", byte[].class.getName());
			put("varbinary", byte[].class.getName());
			put("point", String.class.getName());
			put("linestring", String.class.getName());
			put("polygon", String.class.getName());
			put("geometry", String.class.getName());
			put("multipoint", String.class.getName());
			put("multilinestring", String.class.getName());
			put("multipolygon", String.class.getName());
			put("geometrycollection", String.class.getName());
		}
	};

	/**
	 * Bean的域->VO（View Object）：视图对象.
	 * 用于展示层，它的作用是把某个指定页面（或组件）的所有数据封装起来。
	 */
	public static final String VO = "VO";

	/**
	 * Bean的域->DTO（Data Transfer Object）：数据传输对象.
	 * 这个概念来源于J2EE的设计模式，原来的目的是为了EJB的分布式应用提供粗粒度的数据实体，以减少分布式调用的次数，从而提高分布式调用的性能和降低网络负载，但在这里，我泛指用于展示层与服务层之间的数据传输对象。
	 */
	public static final String DTO = "DTO";

	/**
	 * Bean的域->DO（Domain Object）：领域对象.
	 * 就是从现实世界中抽象出来的有形或无形的业务实体。
	 */
	public static final String DO = "DO";

	/**
	 * Bean的域->PO（Persistent Object）：持久化对象.
	 * 它跟持久层（通常是关系型数据库）的数据结构形成一一对应的映射关系，如果持久层是关系型数据库，那么，数据表中的每个字段（或若干个）就对应PO的一个（或若干个）属性。
	 */
	public static final String PO = "PO";

	/**
	 * Bean的域集合.
	 * new String[]{VO, DTO, DO, PO};</br>
	 * 传输模型：</br>
	 * 1.用户发出请求（可能是填写表单），表单的数据在展示层被匹配为VO。</br>
	 * 2.展示层把VO转换为服务层对应方法所要求的DTO，传送给服务层。</br>
	 * 3.服务层首先根据DTO的数据构造（或重建）一个DO，调用DO的业务方法完成具体业务。</br>
	 * 4.服务层把DO转换为持久层对应的PO（可以使用ORM工具，也可以不用），调用持久层的持久化方法，把PO传递给它，完成持久化操作。</br>
	 * 对于一个逆向操作，如读取数据，也是用类似的方式转换和传递，略。</br>
	 */
	public static String[] BEAN_DOMAIN = new String[]{VO, DTO, DO, PO};

	private GBean(){
		
	}

	/**
	 * 得到实例
	 * @return
	 */
	public static GBean getInstance(){
		return gBean;
	}

	/**
	 * 生成bean基础信息集合.不包括字段信息
	 * @param table 表信息
	 * @return
	 */
	public List<GExcelBeanEntity> getBeanEntity(final Tables table){
		List<GExcelBeanEntity> beanParameterEntities = new ArrayList<GExcelBeanEntity>();

		String tableName = table.getTableName();

		GExcelBeanEntity gExcelBeanEntity = null;
		for(int i = 0, length = BEAN_DOMAIN.length; i < length; i++){
			String beanDomain = BEAN_DOMAIN[i];

			String packageName = GenerateContext.getConfigurable().getBasicPackage() + "." + "api" + "." + "entity" + "." + beanDomain + "." + "模块";// TODO 现在无法得到模块的划分信息，以后开发

			Map<String, String> sqlTempMap = SqlConstant.SQL_TEMPLATE_MAP;
			Set<String> keySet = sqlTempMap.keySet();
			Iterator<String> iterator =  keySet.iterator();

			while(iterator.hasNext()){
				String sqlMethod = iterator.next();
				String tableNameFormat = StringUtils.toJavaParam(tableName);
				String sqlMethodFormat = StringUtils.uppercaseFirstChar(sqlMethod);

				{
					gExcelBeanEntity = new GExcelBeanEntity();

					String beanName = tableNameFormat + sqlMethodFormat + "In" + beanDomain;
					String beanClassName = StringUtils.uppercaseFirstChar(beanName);

					gExcelBeanEntity.setBeanName(beanName);
					gExcelBeanEntity.setBeanClassName(beanClassName);
					gExcelBeanEntity.setDomain(beanDomain);
					gExcelBeanEntity.setPackageName(packageName);
					gExcelBeanEntity.setType("in");

					beanParameterEntities.add(gExcelBeanEntity);
				}
				{
					gExcelBeanEntity = new GExcelBeanEntity();

					String beanName = tableNameFormat + sqlMethodFormat + "Out" + beanDomain;
					String beanClassName = StringUtils.uppercaseFirstChar(beanName);

					gExcelBeanEntity.setBeanName(beanName);
					gExcelBeanEntity.setBeanClassName(beanClassName);
					gExcelBeanEntity.setDomain(beanDomain);
					gExcelBeanEntity.setPackageName(packageName);
					gExcelBeanEntity.setType("out");

					beanParameterEntities.add(gExcelBeanEntity);
				}
			}
		}

		return beanParameterEntities;
	}

	/**
	 * 将数据库字段信息转换为Bean参数
	 * @param columnList 字段信息集合
	 * @return
	 */
	public List<GExcelBeanParameterEntity> getBeanParamEntity(final List<Columns> columnList){
		List<GExcelBeanParameterEntity> beanParameterEntities = new ArrayList<GExcelBeanParameterEntity>();

		GExcelBeanParameterEntity beanParameterEntity = null;
		for(int i = 0, size = columnList.size(); i < size; i++){
			beanParameterEntity = new GExcelBeanParameterEntity();
			Columns column = columnList.get(i);

			beanParameterEntity.setAnnotate(column.getColumnComment());
			beanParameterEntity.setParamName(StringUtils.toJavaParam(column.getColumnName()));

			String mysqlType = column.getDataType();

			// 默认类型为String
			String javaType = String.class.getName();

			// 如果类型映射map里有对应mysql类型则通过此类型作为KEY取出java类型
			if(SQL_TYPE_MAPPING.containsKey(mysqlType)){
				javaType = SQL_TYPE_MAPPING.get(mysqlType);
			}

			beanParameterEntity.setParamType(javaType);

			beanParameterEntities.add(beanParameterEntity);
		}

		return beanParameterEntities;
	}

}
