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
	 * @param filePath 文件路径 返回问题的 list集合
	 * @return
	 *//*
	public static List<JsQuesion> excelToQues(String filePath) {
		List<JsQuesion> list = new ArrayList<JsQuesion>();
		FileInputStream excelFileInputStream;
		XSSFWorkbook workbook = null;
		try {
			excelFileInputStream = new FileInputStream(filePath);
			// XSSFWorkbook 就代表一个 Excel 文件
			// 创建其对象，就打开这个 Excel 文件
			workbook = new XSSFWorkbook(excelFileInputStream);
			// 输入流使用后，及时关闭！这是文件流操作中极好的一个习惯！
			excelFileInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		// XSSFSheet 代表 Excel 文件中的一张表格
		// 我们通过 getSheetAt(0) 指定表格索引来获取对应表格
		// 注意表格索引从 0 开始！
		XSSFSheet sheet = workbook.getSheetAt(1);
		// 开始循环表格数据,表格的行索引从 0 开始
				// employees.xlsx 第一行是标题行，我们从第二行开始, 对应的行索引是 1
				// sheet.getLastRowNum() : 获取当前表格中最后一行数据对应的行索引
//		System.out.println(sheet.getLastRowNum());
				for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
//				for (int rowIndex = 1; rowIndex <= 1963; rowIndex++) {
					JsQuesion jsQuesion = new JsQuesion();
					// XSSFRow 代表一行数据
					XSSFRow row = sheet.getRow(rowIndex);
					if (row == null) {
					continue;
					}
					int type_id = (int) row.getCell(0).getNumericCellValue(); // 题型
					String title_center = row.getCell(1).getStringCellValue(); // 题干
					row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
					String an_A = row.getCell(2).getStringCellValue();//A
					row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
					String an_B = row.getCell(3).getStringCellValue();
					row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
					String an_C = row.getCell(4).getStringCellValue();
					row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
					String an_D = row.getCell(5).getStringCellValue();
					String answer = row.getCell(6).getStringCellValue();
					int difficult_id = (int)row.getCell(8).getNumericCellValue(); // 难易程度
					String exam_type = String.valueOf((int) row.getCell(9).getNumericCellValue());//常规必考
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
	 * 批量导入学生
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
		return list;
	} 
}
*/