package cn.cm.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import cm.cn.po.JsCase;
import cm.cn.po.JsCasequestion;
import cm.cn.po.JsQuesion;
import cm.cn.util.QuesExcelUtil;

public class TestExcel {

	@Test
	public void testEx() {
		String filePath = "C:\\Users\\dnd\\Desktop\\学生信息.xlsx";
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
				for (int rowIndex = 1; rowIndex <= 3; rowIndex++) {
//					JsUser jsUser = new JsUser();
					XSSFRow row = sheet.getRow(rowIndex);
					if (row == null) {
					continue;
					}
//					String name = row.getCell(0).getStringCellValue(); // 姓名
					row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
					String phone = row.getCell(1).getStringCellValue(); // 电话
					System.out.println(phone);
//					String id_card = row.getCell(2).getStringCellValue();//身份证
//					String class_num =  row.getCell(3).getStringCellValue();//班级
//					String stu_type = row.getCell(4).getStringCellValue();//学生类别
//					String pass = row.getCell(5).getStringCellValue();//密码
//					jsUser.setIdcard(id_card);
//					jsUser.setStuType(stu_type);
//					jsUser.setPassword(pass);
//					jsUser.setPhone(phone);
//					jsUser.setRealname(class_num);
//					jsUser.setUsername(name);
//					jsUser.setRoleId(3);
				}
	}
	@Test
	public void toSArray() {
		String str = "a,b,c,d,e,f,g,h,i,j,k";
		String[] array = str.split(",");
		Map<String, String[]> map = new HashMap<>();
		map.put("s", array);
	}

	@Test
	public void toSrray() {
		List<String> list = new ArrayList<>();
		list.add("b");
		list.add("w");
		list.add("d");
		list.add("s");
		list.add("a");
		String strings[] = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			strings[i] = list.get(i);
		}
		StringBuffer stringBuilder = new StringBuffer();

		for (String string : strings) {
			System.out.println(string);
			stringBuilder.append(string + ",");
		}
		System.out.println(stringBuilder.toString());
	}
	@Test
	public void torray() {
		String filePath = "C:\\Users\\dnd\\Documents\\WeChat Files\\wxid_5xxl7t4xw9ws22\\Files\\材料员实务.xls";
		FileInputStream excelFileInputStream;
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
		HSSFSheet sheet = workbook.getSheetAt(3);
		JsCase jsCase = null;
		JsCasequestion jsCasequestion = null;
//		int id = 0;
		for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			HSSFRow row = sheet.getRow(rowIndex);
			if (row == null) {
				continue;
			}
			if ((row.getCell(0).getStringCellValue()).contains("、")) {
				jsCasequestion  = new JsCasequestion();
//				String case_id = row.getCell(1).getCellFormula();
				String content = row.getCell(1).getStringCellValue();//题干
				String an_A = row.getCell(2).getStringCellValue();
				String an_B = row.getCell(3).getStringCellValue();
				String an_C = row.getCell(4).getStringCellValue();
				String an_D = row.getCell(5).getStringCellValue();
				if (row.getCell(6)!=null){
					String an_E = row.getCell(6).getStringCellValue();
					jsCasequestion.setAnE(an_E);
				}
				String answer = row.getCell(7).getStringCellValue();
				jsCasequestion.setContent(content);
				jsCasequestion.setAnA(an_A);
				jsCasequestion.setAnB(an_B);
				jsCasequestion.setAnC(an_C);
				jsCasequestion.setAnD(an_D);
				jsCasequestion.setAnswer(answer);
//				jsCasequestion.setCaseId(id);
			}else{
				jsCase = new JsCase();
//				String case_id = row.getCell(0).getStringCellValue();
				String content = row.getCell(1).getStringCellValue();
				jsCase.setContent(content);
//				id = jsCase.getId();
			}
		}
	
	}
	@Test
	public void testD(){
		String filePath = "C:\\Users\\dnd\\Documents\\WeChat Files\\wxid_5xxl7t4xw9ws22\\Files\\电工.xlsx";
		List<JsQuesion> list = QuesExcelUtil.excelToQues(filePath);
		System.out.println(list.size());
	}
	
}
