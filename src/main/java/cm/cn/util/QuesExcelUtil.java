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
	 * @param filePath 文件路径 返回问题的 list集合
	 * @return
	 * 导入的是第二张表
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
			// 注意表格索引从 0 开始！
			HSSFSheet sheet = workbook.getSheetAt(1);
			// 开始循环表格数据,表格的行索引从 0 开始
			for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				JsQuesion jsQuesion = new JsQuesion();
				HSSFRow row = sheet.getRow(rowIndex);
				if (row == null) {
					continue;
				}
				int type_id = (int) row.getCell(0).getNumericCellValue(); // 题型
				String title_center = row.getCell(1).getStringCellValue(); // 题干
				row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
				String strABCD = row.getCell(2).getStringCellValue();//A,B,C,D四个选项内容
				String[] str = strABCD.split("[A-D]\\、");
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
					//解析
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
			for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
//					for (int rowIndex = 1; rowIndex <= 1963; rowIndex++) {
				JsQuesion jsQuesion = new JsQuesion();
						// XSSFRow 代表一行数据
				XSSFRow row = sheet.getRow(rowIndex);
				if (row == null) {
					continue;
				}
				int type_id = (int) row.getCell(0).getNumericCellValue(); // 题型
				String title_center = row.getCell(1).getStringCellValue(); // 题干
				row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
				String strABCD = row.getCell(2).getStringCellValue();//A,B,C,D四个选项内容
				String[] str = strABCD.split("[A-D]\\、");
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
					//解析
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
