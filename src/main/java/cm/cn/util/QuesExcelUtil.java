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
				String strABCD = row.getCell(2).getStringCellValue();//A,B,C,D�ĸ�ѡ������
				String[] str = strABCD.split("[A-D]\\��");
				if (type_id==3) {
					String an_A = str[1];
					String an_B = str[2];
					jsQuesion.setAnA(an_A);
					jsQuesion.setAnB(an_B);
				}
				else{
					String an_A = str[1];
					String an_B = str[2];
					String an_C = str[3];
					String an_D = str[4];
					jsQuesion.setAnA(an_A);
					jsQuesion.setAnB(an_B);
					jsQuesion.setAnC(an_C);
					jsQuesion.setAnD(an_D);
				}
				String answer = row.getCell(3).getStringCellValue();
				if (row.getCell(4)!=null){
					//����
					String reserveOne = row.getCell(4).getStringCellValue();
					jsQuesion.setReserveOne(reserveOne);
				}
				jsQuesion.setTitle(title_center);
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
				String strABCD = row.getCell(2).getStringCellValue();//A,B,C,D�ĸ�ѡ������
				String[] str = strABCD.split("[A-D]\\��");
				if (type_id==3) {
					String an_A = str[1];
					String an_B = str[2];
					jsQuesion.setAnA(an_A);
					jsQuesion.setAnB(an_B);
				}
				else{
					String an_A = str[1];
					String an_B = str[2];
					String an_C = str[3];
					String an_D = str[4];
					jsQuesion.setAnA(an_A);
					jsQuesion.setAnB(an_B);
					jsQuesion.setAnC(an_C);
					jsQuesion.setAnD(an_D);
				}
				String answer = row.getCell(3).getStringCellValue();
				if (row.getCell(4)!=null){
					//����
					String reserveOne = row.getCell(4).getStringCellValue();
					jsQuesion.setReserveOne(reserveOne);
				}
				jsQuesion.setTitle(title_center);
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
