package cm.cn.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cm.cn.po.JsQuesion;

public class ListQuesToExcel {
	//将 sql 导出到 Excel 中
		public static void questionToExcel(List<JsQuesion> list){
			  // 创建一个Excel文件
		    XSSFWorkbook workbook = new XSSFWorkbook();
		    // 创建一个工作表
		   XSSFSheet sheet = workbook.createSheet("题目列表");
		    // 添加表头行
		    XSSFRow hssfRow = sheet.createRow(0);
		    // 设置单元格格式居中
		    XSSFCellStyle cellStyle = workbook.createCellStyle();
		    cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		 
		    // 添加表头内容
		    XSSFCell headCell = hssfRow.createCell(0);
		    headCell.setCellValue("题目类型");
		    headCell.setCellStyle(cellStyle);
		 
		    headCell = hssfRow.createCell(1);
		    headCell.setCellValue("题目");
		    headCell.setCellStyle(cellStyle);
		 
		    headCell = hssfRow.createCell(2);
		    headCell.setCellValue("A选项");
		    headCell.setCellStyle(cellStyle);
		    
		    headCell = hssfRow.createCell(3);
		    headCell.setCellValue("B选项");
		    headCell.setCellStyle(cellStyle);
		    
		    headCell = hssfRow.createCell(4);
		    headCell.setCellValue("C选项");
		    headCell.setCellStyle(cellStyle);
		    
		    headCell = hssfRow.createCell(5);
		    headCell.setCellValue("D选项");
		    headCell.setCellStyle(cellStyle);
		    
		    headCell = hssfRow.createCell(5);
		    headCell.setCellValue("答案");
		    headCell.setCellStyle(cellStyle);
		    for (int i = 0; i < list.size(); i++){
		    	hssfRow = sheet.createRow((int) i + 1);
		    	JsQuesion jsQuesion = list.get(i);
		    	// 添加表头内容
			    XSSFCell cell = hssfRow.createCell(0);
			    cell.setCellValue(jsQuesion.getTypeId());
			    cell.setCellStyle(cellStyle);
			    
			    cell = hssfRow.createCell(1);
			    cell.setCellValue(jsQuesion.getTitle());
			    cell.setCellStyle(cellStyle);
			    
			    cell = hssfRow.createCell(2);
			    cell.setCellValue(jsQuesion.getAnA());
			    cell.setCellStyle(cellStyle);
			    
			    cell = hssfRow.createCell(3);
//			    cell.setCellValue(jsUser.getPhone());
			    cell.setCellStyle(cellStyle);
			    
			    cell = hssfRow.createCell(4);
//			    cell.setCellValue(jsUser.getIdcard());
			    cell.setCellStyle(cellStyle);
			    
			    cell = hssfRow.createCell(5);
//			    cell.setCellValue(jsUser.getStuType());
			    headCell.setCellStyle(cellStyle);
		    }
		    // 保存Excel文件
		    try {
			 //文件扩展名  
			 String newFileName = UUID.randomUUID()+""+new Date().getTime()+".xlsx";  
			    
			 // 存储视屏的物理路径
			 String video_path = "D:\\FFOutput\\";
			 OutputStream outputStream = new FileOutputStream(video_path+newFileName);
			 workbook.write(outputStream);
			 outputStream.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		}
}
