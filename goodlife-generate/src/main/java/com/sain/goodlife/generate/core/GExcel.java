package com.sain.goodlife.generate.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sain.goodlife.generate.core.entity.GExcelEntity;
import com.sain.goodlife.generate.core.jxls.JxlsExcelTemplate;
import com.sain.goodlife.generate.po.Columns;
import com.sain.goodlife.generate.po.Tables;

/**
 * 生成配置信息
 * @author ddtt
 *
 */
public class GExcel {

	private static final Logger LOGGER = LoggerFactory.getLogger(GExcel.class);

	private static GExcel gExcel = new GExcel();

	private GExcel(){
	}

	/**
	 * 得到实例
	 * @return
	 */
	public static GExcel getInstance(){
		return gExcel;
	}

	/**
	 *  根据table信息生成excel配置文件
	 * @param table
	 */
	public boolean createExcelCnfFile(Tables table){
		boolean flag = false;

		String tableName = table.getTableName();
		String tableComment = table.getTableComment();

		// excel模板输入流
		InputStream templateInputStream = null;
		// excel配置输出流
		OutputStream exportOutputStream = null;
		try {
			templateInputStream = JxlsExcelTemplate.getTemplateInputStream(JxlsExcelTemplate.EXCEL_TEMLPATE_PATH);

			String exportFileName = tableName + "[" + tableComment + "].xls";
			exportOutputStream = JxlsExcelTemplate.getExportFileOutputStream(exportFileName);
		} catch (IOException ioe) {
			LOGGER.error("DATE[" + new Date(System.currentTimeMillis()) + "] : " + JxlsExcelTemplate.EXCEL_TEMLPATE_PATH + " OR " + JxlsExcelTemplate.EXPORT_FOLDER_PATH + "NOT EXIST!");
			ioe.printStackTrace();
		}

		GExcelEntity gExcelEntity = getGExcelEntity(table);

		Map<String, Object> xlsTemplateBeans = new HashMap<String, Object>();
		xlsTemplateBeans.put("gExcelEntity", gExcelEntity);

		//关联模板
		XLSTransformer transformer = new XLSTransformer();
		// 创建新的Excel 工作簿
		try {
			Workbook workbook = transformer.transformXLS(templateInputStream, xlsTemplateBeans);

			workbook.write(exportOutputStream);

			flag = true;
		} catch (ParsePropertyException e) {
			flag = false;
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			flag = false;
			e.printStackTrace();
		} catch (IOException e) {
			flag = false;
			e.printStackTrace();
		}

		return flag;
	}

	private GExcelEntity getGExcelEntity(Tables table){
		String tableName = table.getTableName();
//		String tableComment = table.getTableComment();
		List<Columns> columnList = table.getColumns();

		// TODO
//		List<Columns> priColumnList = new ArrayList<Columns>();
//		List<Columns> othColumnList = new ArrayList<Columns>();
//		for(int i = 0, size = columnList.size(); i < size; i++){
//			Columns column = columnList.get(i);
//			String columnKey = column.getColumnKey();
//			if(StringUtils.isNotEmpty(columnKey) && "PRI".equals(columnKey)){
//				priColumnList.add(column);
//			} else {
//				othColumnList.add(column);
//			}
//		}

//		StringBuilder sql = new StringBuilder();
//		sql.append("INSERT INTO ");
//		sql.append(tableName);
//		sql.append("(");
//		for(int i = 0, size = othColumnList.size(); i < size; i++){
//			Columns column = columnList.get(i);
//			sql.append(column.getColumnName());
//			if(i != size -1){
//				sql.append(",");
//			}
//		}
//		sql.append(") VALUES(");
//		for(int i = 0, size = othColumnList.size(); i < size; i++){
//			Columns column = columnList.get(i);
//			sql.append(":");
//			sql.append(column.getColumnName());
//			if(i != size -1){
//				sql.append(",");
//			}
//		}
//		sql.append(");");

		GExcelEntity gExcelEntity = new GExcelEntity();

		// 设置bean字段集合
		gExcelEntity.setgExcelBeanParameterEntities(GBean.getInstance().getBeanParamEntity(columnList));
		// 设置bean集合
		gExcelEntity.setgExcelBeanEntities(GBean.getInstance().getBeanEntity(table));
		// 设置sql
		gExcelEntity.setgExcelSqlEntities(GSql.getInstance().getSqlEntitys(tableName, columnList));

		return gExcelEntity;
	}

}
