package cm.cn.util;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cm.cn.po.JsUser;

public class ListStuToExcel {
	//将 sql 导出到 Excel 中
	public static XSSFWorkbook questionToExcel(List<JsUser> list){
		  // 创建一个Excel文件
	    XSSFWorkbook workbook = new XSSFWorkbook();
	    // 创建一个工作表
	   XSSFSheet sheet = workbook.createSheet("学生信息表");
	    // 添加表头行
	    XSSFRow hssfRow = sheet.createRow(0);
	    // 设置单元格格式居中
	    XSSFCellStyle cellStyle = workbook.createCellStyle();
	    cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
	 
	    // 添加表头内容
	    XSSFCell headCell = hssfRow.createCell(0);
	    headCell.setCellValue("姓名");
	    headCell.setCellStyle(cellStyle);
	 
//	    headCell = hssfRow.createCell(1);
//	    headCell.setCellValue("密码");
//	    headCell.setCellStyle(cellStyle);
	 
	    headCell = hssfRow.createCell(1);
	    headCell.setCellValue("年级");
	    headCell.setCellStyle(cellStyle);
	    
	    headCell = hssfRow.createCell(2);
	    headCell.setCellValue("电话");
	    headCell.setCellStyle(cellStyle);
	    
	    headCell = hssfRow.createCell(3);
	    headCell.setCellValue("身份证");
	    headCell.setCellStyle(cellStyle);
	    
//	    headCell = hssfRow.createCell(5);
//	    headCell.setCellValue("学生类别");
//	    headCell.setCellStyle(cellStyle);
	    for (int i = 0; i < list.size(); i++){
	    	hssfRow = sheet.createRow((int) i + 1);
	    	JsUser jsUser = list.get(i);
	    	// 添加表头内容
		    XSSFCell cell = hssfRow.createCell(0);
		    cell.setCellValue(jsUser.getUsername());
		    cell.setCellStyle(cellStyle);
		    
//		    cell = hssfRow.createCell(1);
//		    cell.setCellValue(jsUser.getPassword());
//		    cell.setCellStyle(cellStyle);
		    
		    cell = hssfRow.createCell(1);
		    cell.setCellValue(jsUser.getRealname());
		    cell.setCellStyle(cellStyle);
		    
		    cell = hssfRow.createCell(2);
		    cell.setCellValue(jsUser.getPhone());
		    cell.setCellStyle(cellStyle);
		    
		    cell = hssfRow.createCell(3);
		    cell.setCellValue(jsUser.getIdcard());
		    cell.setCellStyle(cellStyle);
		    
//		    cell = hssfRow.createCell(5);
//		    cell.setCellValue(jsUser.getStuType());
//		    headCell.setCellStyle(cellStyle);
	    }
	    // 保存Excel文件
//	    try {
		 //文件扩展名  
//		 String newFileName = UUID.randomUUID()+""+new Date().getTime()+".xlsx";  
		    
		 // 存储视屏的物理路径
//		 String video_path = "D:\\";
//		 OutputStream outputStream = new FileOutputStream(video_path+newFileName);
//		 workbook.write(outputStream);
//		 outputStream.close();
//	    } catch (Exception e) {
//	      e.printStackTrace();
//	    }
	    return workbook;
	}
}
