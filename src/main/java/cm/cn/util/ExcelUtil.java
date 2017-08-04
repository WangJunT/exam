package cm.cn.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cm.cn.po.JsCasequestion;
import cm.cn.po.JsQuesion;
import cm.cn.po.JsUser;

public class ExcelUtil {
	/**
	 * 
	 * @param filePath �ļ�·�� ��������� list����
	 * @return
	 */
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		// XSSFSheet ���� Excel �ļ��е�һ�ű��
		// ����ͨ�� getSheetAt(0) ָ�������������ȡ��Ӧ���
		// ע���������� 0 ��ʼ��
		XSSFSheet sheet = workbook.getSheetAt(2);
		// ��ʼѭ���������,������������ 0 ��ʼ
				// employees.xlsx ��һ���Ǳ����У����Ǵӵڶ��п�ʼ, ��Ӧ���������� 1
				// sheet.getLastRowNum() : ��ȡ��ǰ��������һ�����ݶ�Ӧ��������
				for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
//				for (int rowIndex = 1; rowIndex <= 3; rowIndex++) {
					JsQuesion jsQuesion = new JsQuesion();
					// XSSFRow ����һ������
					XSSFRow row = sheet.getRow(rowIndex);
					if (row == null) {
					continue;
					}
					int type_id = (int) row.getCell(0).getNumericCellValue(); // ����
					String title_center = row.getCell(1).getStringCellValue(); // ���
					String option = row.getCell(2).getStringCellValue();//ѡ������
					int option_num = (int) row.getCell(3).getNumericCellValue();//�ж���ѡ��
					String answer = row.getCell(4).getStringCellValue();
					jsQuesion.setTitle(title_center);
					jsQuesion.setContent(option);
					jsQuesion.setTypeId(type_id);
					jsQuesion.setOptionNumber(option_num);
					jsQuesion.setAnswer(answer);
					list.add(jsQuesion);
				}
		return list;
	}
	/**
	 * ��������ѧ��
	 * @param filePath
	 * @return
	 */
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
//	public static List<JsCasequestion> excelToJsCase(String path){
//		List<JsCasequestion> list = new ArrayList<JsUser>();
//		FileInputStream excelFileInputStream;
//		XSSFWorkbook workbook = null;
//		try {
//			excelFileInputStream = new FileInputStream(path);
//			workbook = new XSSFWorkbook(excelFileInputStream);
//			excelFileInputStream.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}catch(IOException e){
//			e.printStackTrace();
//		}
//		
//		XSSFSheet sheet = workbook.getSheetAt(0);
//				for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
//					JsUser jsUser = new JsUser();
//					XSSFRow row = sheet.getRow(rowIndex);
//					if (row == null) {
//					continue;
//					}
//					String name = row.getCell(0).getStringCellValue(); // ����
//					//������Cell�����ͣ�Ȼ��Ϳ��԰Ѵ�������ΪString���Ͷ������ˣ�
//					row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
//					String phone = row.getCell(1).getStringCellValue(); // �绰
//					String id_card = row.getCell(2).getStringCellValue();//���֤
//					String class_num =  row.getCell(3).getStringCellValue();//�༶
//					String stu_type = row.getCell(4).getStringCellValue();//ѧ�����
//					row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
//					String pass = row.getCell(5).getStringCellValue();//����
//					jsUser.setIdcard(id_card);
//					jsUser.setStuType(stu_type);
//					jsUser.setPassword(pass);
//					jsUser.setPhone(phone);
//					jsUser.setRealname(class_num);
//					jsUser.setUsername(name);
//					jsUser.setRoleId(3);
//					list.add(jsUser);
//				}
//		return list;
//	}
}
