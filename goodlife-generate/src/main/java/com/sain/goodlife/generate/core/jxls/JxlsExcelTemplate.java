package com.sain.goodlife.generate.core.jxls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JxlsExcelTemplate {

	private static final Logger LOGGER = LoggerFactory.getLogger(JxlsExcelTemplate.class);

	/**
	 * 路径标识符，此标志用来从classpath路径下寻找文件
	 */
	public static final String CLASSPATH_PREFIX = "classpath:";

	/**
	 * 路径标识符，使用URL从网络上加载文件
	 */
	public static final String URL_PREFIX = "url:";

	/**
	 * 路径标识符，此标志基于文件系统寻找文件
	 */
	public static final String FILE_PREFIX = "file:";

	/**
	 * 【模板路径】Excel配置生成模版路径
	 */
	public static final String EXCEL_TEMLPATE_PATH = "classpath:template/excel/template.xls";

	/**
	 * 【excel配置路径】存放生成的excel配置的路径，是一个文件夹路径
	 */
	public static final String EXPORT_FOLDER_PATH = "classpath:readFiles";

	/**
	 * 根据模版路径得到模板的输入流
	 * @param templatePath
	 * @return 
	 * @throws IOException 
	 */
	public static InputStream getTemplateInputStream (String templatePath) throws IOException{
		InputStream templateInputStream = null;

		if(templatePath != null && !"".equals(templatePath)){
			if(templatePath.startsWith(CLASSPATH_PREFIX)){
				templateInputStream = JxlsExcelTemplate.class.getResourceAsStream(templatePath.replaceFirst(CLASSPATH_PREFIX, "/"));

			} else if(templatePath.startsWith(URL_PREFIX)){
				URL url = new URL(templatePath.substring(URL_PREFIX.length()));
				templateInputStream = url.openStream();

			} else if(templatePath.startsWith(FILE_PREFIX)){
				templateInputStream = new FileInputStream(templatePath.substring(templatePath.indexOf(":") + 1));

			} else {
				// String basePath = System.getProperty("user.dir"); // TODO 有兼容性问题

				String basePath = JxlsExcelTemplate.class.getResource("/").getPath();
				basePath = basePath.substring(0, basePath.indexOf("/WEB-INF"));

				templateInputStream = new FileInputStream(basePath + templatePath);
			}
		}

		if (templateInputStream == null) {
			LOGGER.error("DATE[" + new Date(System.currentTimeMillis()) + "] : " + templatePath + "NOT FOUND!");
			throw new TemplateFileNotFoundException("Template " + templatePath + " not found.");
		}

		return templateInputStream;
	}

	/**
	 * 根据指定的文件名,获取导出文件输出流
	 * @return
	 */
	public static OutputStream getExportFileOutputStream (String fileName) {
		return getExportFileOutputStream(EXPORT_FOLDER_PATH, fileName);
	}

	/**
	 * 根据指定的excel导出文件路径夹和文件名,获取导出文件输出流
	 * @return
	 * @throws FileNotFoundException 
	 */
	public static OutputStream getExportFileOutputStream (String folderPath, String fileName) {
		if (fileName == null || "".equals(fileName)) {
			return null;
		}
		if (folderPath == null || "".equals(folderPath)) {
			folderPath = EXPORT_FOLDER_PATH;
		}

		String exportFolderPath = folderPath;

		if(folderPath.startsWith(CLASSPATH_PREFIX)){
			exportFolderPath = JxlsExcelTemplate.class.getResource("/").getPath() + folderPath.replaceFirst(CLASSPATH_PREFIX, "/");
		} else if(folderPath.startsWith(FILE_PREFIX)){
			exportFolderPath = folderPath.substring(folderPath.indexOf(":") + 1);
		} else {
			String basePath = JxlsExcelTemplate.class.getResource("/").getPath();
			basePath = basePath.substring(0, basePath.indexOf("/WEB-INF"));

			exportFolderPath = basePath + "/" + folderPath;
		}

		File exportFolder = new File(exportFolderPath);
		if(!exportFolder.exists()){
			exportFolder.mkdirs();
		}

		String exportFilePath = exportFolder.getPath() + "/" + fileName;

		OutputStream exportOutputStream = null;

		try {
			exportOutputStream = new FileOutputStream(exportFilePath);
		} catch (FileNotFoundException e) {
			LOGGER.error("DATE[" + new Date(System.currentTimeMillis()) + "] : " + exportFilePath + "NOT FOUND!");
			// TODO throws XxxxxxException()
			e.printStackTrace();
		}

		return exportOutputStream;
	}

	private JxlsExcelTemplate(){
		
	}
}
