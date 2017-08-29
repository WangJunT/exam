package cm.cn.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cm.cn.po.JsQuesion;

public class QuesExcelUtil {
	/**
	 * @param filePath �ļ�·�� ��������� list����
	 * @return
	 * ������ǵڶ��ű�
	 */
	public static List<JsQuesion> excelToQues(String filePath,String reserveFive,String reserveSix) {
		List<JsQuesion> list = new ArrayList<JsQuesion>();
		FileInputStream excelFileInputStream;
		String filetype = filePath.substring(filePath.lastIndexOf(".") + 1);
		if (".xls".equals(filetype.toLowerCase())) {
			HSSFWorkbook workbook = null;
			try {
				excelFileInputStream = new FileInputStream(filePath);
				workbook = new HSSFWorkbook(excelFileInputStream);
				excelFileInputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
			// ע���������� 0 ��ʼ��
			HSSFSheet sheet = workbook.getSheetAt(1);
			// ��ʼѭ���������,������������ 0 ��ʼ
			for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				JsQuesion jsQuesion = new JsQuesion();
				HSSFRow row = sheet.getRow(rowIndex);
				if (row == null) {
					continue;
				}
				int type_id = (int) row.getCell(0).getNumericCellValue(); // ����
				String title_center = row.getCell(1).getStringCellValue(); // ���
				row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
				String an_A = row.getCell(2).getStringCellValue();//A
				row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
				String an_B = row.getCell(3).getStringCellValue();
				row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
				String an_C = row.getCell(4).getStringCellValue();
				row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
				String an_D = row.getCell(5).getStringCellValue();
				String answer = row.getCell(6).getStringCellValue();
				if (row.getCell(7)!=null){
					//����
					String reserveOne = row.getCell(7).getStringCellValue();
					jsQuesion.setReserveOne(reserveOne);
				}
//				int difficult_id = (int)row.getCell(7).getNumericCellValue(); // ���׳̶�
//				String exam_type = String.valueOf((int) row.getCell(8).getNumericCellValue());//����ؿ�
				jsQuesion.setTitle(title_center);
				jsQuesion.setAnA(an_A);
				jsQuesion.setAnB(an_B);
				jsQuesion.setAnC(an_C);
				jsQuesion.setAnD(an_D);
//				jsQuesion.setDifficultType(difficult_id);
//				jsQuesion.setExamType(exam_type);
				jsQuesion.setTypeId(type_id);
				jsQuesion.setAnswer(answer);
				jsQuesion.setReserveFive(reserveFive);
				jsQuesion.setReserveSix(reserveSix);
				list.add(jsQuesion);
			}
		}
		if ("xlsx".equals(filetype.toLowerCase())) {
			XSSFWorkbook workbook = null;
			try {
				excelFileInputStream = new FileInputStream(filePath);
				// XSSFWorkbook �ʹ���һ�� Excel �ļ�
				// ��������󣬾ʹ���� Excel �ļ�
				workbook = new XSSFWorkbook(excelFileInputStream);
				// ������ʹ�ú󣬼�ʱ�رգ������ļ��������м��õ�һ��ϰ�ߣ�
				excelFileInputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
			// XSSFSheet ���� Excel �ļ��е�һ�ű��
			// ����ͨ�� getSheetAt(0) ָ�������������ȡ��Ӧ���
			// ע���������� 0 ��ʼ��
			XSSFSheet sheet = workbook.getSheetAt(1);
			// ��ʼѭ���������,������������ 0 ��ʼ
					// employees.xlsx ��һ���Ǳ����У����Ǵӵڶ��п�ʼ, ��Ӧ���������� 1
					// sheet.getLastRowNum() : ��ȡ��ǰ��������һ�����ݶ�Ӧ��������
//			System.out.println(sheet.getLastRowNum());
			for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
//					for (int rowIndex = 1; rowIndex <= 1963; rowIndex++) {
				JsQuesion jsQuesion = new JsQuesion();
						// XSSFRow ����һ������
				XSSFRow row = sheet.getRow(rowIndex);
				if (row == null) {
					continue;
				}
				int type_id = (int) row.getCell(0).getNumericCellValue(); // ����
				String title_center = row.getCell(1).getStringCellValue(); // ���
				row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
				String an_A = row.getCell(2).getStringCellValue();//A
				row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
				String an_B = row.getCell(3).getStringCellValue();
				row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
				String an_C = row.getCell(4).getStringCellValue();
				row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
				String an_D = row.getCell(5).getStringCellValue();
				String answer = row.getCell(6).getStringCellValue();
				if (row.getCell(7)!=null){
					//����
					String reserveOne = row.getCell(7).getStringCellValue();
					jsQuesion.setReserveOne(reserveOne);
				}
//				int difficult_id = (int)row.getCell(8).getNumericCellValue(); // ���׳̶�
//				String exam_type = String.valueOf((int) row.getCell(9).getNumericCellValue());//����ؿ�
				jsQuesion.setTitle(title_center);
				jsQuesion.setAnA(an_A);
				jsQuesion.setAnB(an_B);
				jsQuesion.setAnC(an_C);
				jsQuesion.setAnD(an_D);
//				jsQuesion.setDifficultType(difficult_id);
//				jsQuesion.setExamType(exam_type);
				jsQuesion.setTypeId(type_id);
				jsQuesion.setAnswer(answer);
				jsQuesion.setReserveFive(reserveFive);
				jsQuesion.setReserveSix(reserveSix);
				list.add(jsQuesion);
			}
		}
		return list;
	}
}
