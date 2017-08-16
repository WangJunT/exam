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
	//�� sql ������ Excel ��
		public static void questionToExcel(List<JsQuesion> list){
			  // ����һ��Excel�ļ�
		    XSSFWorkbook workbook = new XSSFWorkbook();
		    // ����һ��������
		   XSSFSheet sheet = workbook.createSheet("��Ŀ�б�");
		    // ��ӱ�ͷ��
		    XSSFRow hssfRow = sheet.createRow(0);
		    // ���õ�Ԫ���ʽ����
		    XSSFCellStyle cellStyle = workbook.createCellStyle();
		    cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		 
		    // ��ӱ�ͷ����
		    XSSFCell headCell = hssfRow.createCell(0);
		    headCell.setCellValue("��Ŀ����");
		    headCell.setCellStyle(cellStyle);
		 
		    headCell = hssfRow.createCell(1);
		    headCell.setCellValue("��Ŀ");
		    headCell.setCellStyle(cellStyle);
		 
		    headCell = hssfRow.createCell(2);
		    headCell.setCellValue("Aѡ��");
		    headCell.setCellStyle(cellStyle);
		    
		    headCell = hssfRow.createCell(3);
		    headCell.setCellValue("Bѡ��");
		    headCell.setCellStyle(cellStyle);
		    
		    headCell = hssfRow.createCell(4);
		    headCell.setCellValue("Cѡ��");
		    headCell.setCellStyle(cellStyle);
		    
		    headCell = hssfRow.createCell(5);
		    headCell.setCellValue("Dѡ��");
		    headCell.setCellStyle(cellStyle);
		    
		    headCell = hssfRow.createCell(5);
		    headCell.setCellValue("��");
		    headCell.setCellStyle(cellStyle);
		    for (int i = 0; i < list.size(); i++){
		    	hssfRow = sheet.createRow((int) i + 1);
		    	JsQuesion jsQuesion = list.get(i);
		    	// ��ӱ�ͷ����
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
		    // ����Excel�ļ�
		    try {
			 //�ļ���չ��  
			 String newFileName = UUID.randomUUID()+""+new Date().getTime()+".xlsx";  
			    
			 // �洢����������·��
			 String video_path = "D:\\FFOutput\\";
			 OutputStream outputStream = new FileOutputStream(video_path+newFileName);
			 workbook.write(outputStream);
			 outputStream.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		}
}
