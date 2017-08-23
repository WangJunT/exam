package cm.cn.util;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cm.cn.po.JsQuesion;

public class ListQuesToExcel {
	//将 sql 导出到 Excel 中
		public static XSSFWorkbook questionToExcel(List<JsQuesion> list){
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
		    
		    headCell = hssfRow.createCell(6);
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
			    cell.setCellValue(jsQuesion.getAnB());
			    cell.setCellStyle(cellStyle);
			    
			    cell = hssfRow.createCell(4);
			    cell.setCellValue(jsQuesion.getAnC());
			    cell.setCellStyle(cellStyle);
			    
			    cell = hssfRow.createCell(5);
			    cell.setCellValue(jsQuesion.getAnD());
			    headCell.setCellStyle(cellStyle);
			    
			    cell = hssfRow.createCell(6);
			    cell.setCellValue(jsQuesion.getAnswer());
			    headCell.setCellStyle(cellStyle);
		    }
		    return workbook;
		}
}
