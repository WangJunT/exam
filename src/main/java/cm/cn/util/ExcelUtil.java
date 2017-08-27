/*package cm.cn.util;

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
import org.springframework.beans.factory.annotation.Autowired;

import cm.cn.po.JsQuesion;
import cm.cn.po.JsUser;
import cm.cn.service.QuestionService;

public class ExcelUtil {
	@Autowired
	QuestionService questionService;
	*//**
	 * @param filePath �ļ�·�� ��������� list����
	 * @return
	 *//*
	public static List<JsQuesion> excelToQues(String filePath) {
		List<JsQuesion> list = new ArrayList<JsQuesion>();
		FileInputStream excelFileInputStream;
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
//		System.out.println(sheet.getLastRowNum());
				for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
//				for (int rowIndex = 1; rowIndex <= 1963; rowIndex++) {
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
					int difficult_id = (int)row.getCell(8).getNumericCellValue(); // ���׳̶�
					String exam_type = String.valueOf((int) row.getCell(9).getNumericCellValue());//����ؿ�
					jsQuesion.setTitle(title_center);
					jsQuesion.setAnA(an_A);
					jsQuesion.setAnB(an_B);
					jsQuesion.setAnC(an_C);
					jsQuesion.setAnD(an_D);
					jsQuesion.setDifficultType(difficult_id);
					jsQuesion.setExamType(exam_type);
					jsQuesion.setTypeId(type_id);
					jsQuesion.setAnswer(answer);
					list.add(jsQuesion);
				}
		return list;
	}
	*//**
	 * ��������ѧ��
	 * @param filePath
	 * @return
	 *//*
	public static List<JsUser> excelToStu(String filePath) {
		List<JsUser> list = new ArrayList<JsUser>();
		FileInputStream excelFileInputStream;
		XSSFWorkbook workbook = null;
		try {
			excelFileInputStream = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(excelFileInputStream);
			excelFileInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheetAt(0);
				for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
					JsUser jsUser = new JsUser();
					XSSFRow row = sheet.getRow(rowIndex);
					if (row == null) {
					continue;
					}
					String name = row.getCell(0).getStringCellValue(); // ����
					//������Cell�����ͣ�Ȼ��Ϳ��԰Ѵ�������ΪString���Ͷ������ˣ�
					row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
					String phone = row.getCell(1).getStringCellValue(); // �绰
					String id_card = row.getCell(2).getStringCellValue();//���֤
					String class_num =  row.getCell(3).getStringCellValue();//�༶
					String stu_type = row.getCell(4).getStringCellValue();//ѧ�����
					row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
					String pass = row.getCell(5).getStringCellValue();//����
					jsUser.setIdcard(id_card);
					jsUser.setStuType(stu_type);
					jsUser.setPassword(pass);
					jsUser.setPhone(phone);
					jsUser.setRealname(class_num);
					jsUser.setUsername(name);
					jsUser.setRoleId(3);
					list.add(jsUser);
				}
		return list;
	} 
}
*/