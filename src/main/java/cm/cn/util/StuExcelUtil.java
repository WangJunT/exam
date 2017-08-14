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

import cm.cn.po.JsUser;

public class StuExcelUtil {
	/**
	 * 批量导入学生
	 * @param filePath
	 * @return
	 * 导入的是第一张表
	 */
	public static List<JsUser> excelToStu(String filePath) {
		List<JsUser> list = new ArrayList<JsUser>();
		FileInputStream excelFileInputStream;
		String filetype = filePath.substring(filePath.lastIndexOf(".") + 1);
		if ("xlsx".equals(filetype.toLowerCase())) {
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
				String name = row.getCell(0).getStringCellValue(); // 姓名
				//先设置Cell的类型，然后就可以把纯数字作为String类型读进来了：
				row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
				String phone = row.getCell(1).getStringCellValue(); // 电话
				String id_card = row.getCell(2).getStringCellValue();//身份证
				String class_num =  row.getCell(3).getStringCellValue();//班级
				String stu_type = row.getCell(4).getStringCellValue();//学生类别
				row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
				String pass = row.getCell(5).getStringCellValue();//密码
				String password = Base64.encode(("zjedu"+pass+"cn").getBytes());
				jsUser.setIdcard(id_card);
				jsUser.setStuType(stu_type);
				jsUser.setPassword(password);
				jsUser.setPhone(phone);
				jsUser.setRealname(class_num);
				jsUser.setUsername(name);
				jsUser.setRoleId(3);
				list.add(jsUser);
			}
		}
		if ("xls".equals(filetype.toLowerCase())) {
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
			HSSFSheet sheet = workbook.getSheetAt(0);
			for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				JsUser jsUser = new JsUser();
				HSSFRow row = sheet.getRow(rowIndex);
				if (row == null) {
					continue;
				}
				String name = row.getCell(0).getStringCellValue(); // 姓名
				//先设置Cell的类型，然后就可以把纯数字作为String类型读进来了：
				row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
				String phone = row.getCell(1).getStringCellValue(); // 电话
				String id_card = row.getCell(2).getStringCellValue();//身份证
				String class_num =  row.getCell(3).getStringCellValue();//班级
				String stu_type = row.getCell(4).getStringCellValue();//学生类别
				row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
				String pass = row.getCell(5).getStringCellValue();//密码
				jsUser.setIdcard(id_card);
				jsUser.setStuType(stu_type);
				jsUser.setPassword(pass);
				jsUser.setPhone(phone);
				jsUser.setRealname(class_num);
				jsUser.setUsername(name);
				jsUser.setRoleId(3);
				list.add(jsUser);
			}
		}
		return list;
	} 
}
