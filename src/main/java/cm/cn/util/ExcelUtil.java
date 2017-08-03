package cm.cn.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cm.cn.po.JsQuesion;

public class ExcelUtil {
	/**
	 * 
	 * @param filePath 文件路径 返回问题的 list集合
	 * @return
	 */
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		// XSSFSheet 代表 Excel 文件中的一张表格
		// 我们通过 getSheetAt(0) 指定表格索引来获取对应表格
		// 注意表格索引从 0 开始！
		XSSFSheet sheet = workbook.getSheetAt(2);
		// 开始循环表格数据,表格的行索引从 0 开始
				// employees.xlsx 第一行是标题行，我们从第二行开始, 对应的行索引是 1
				// sheet.getLastRowNum() : 获取当前表格中最后一行数据对应的行索引
				for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
//				for (int rowIndex = 1; rowIndex <= 3; rowIndex++) {
					JsQuesion jsQuesion = new JsQuesion();
					// XSSFRow 代表一行数据
					XSSFRow row = sheet.getRow(rowIndex);
					if (row == null) {
					continue;
					}
					int type_id = (int) row.getCell(0).getNumericCellValue(); // 题型
					String title_center = row.getCell(1).getStringCellValue(); // 题干
					String option = row.getCell(2).getStringCellValue();//选项内容
					int option_num = (int) row.getCell(3).getNumericCellValue();//有多少选项
					String answer = row.getCell(4).getStringCellValue();
					jsQuesion.setTitle(title_center);
					jsQuesion.setContent(option);
					jsQuesion.setTypeId(type_id);
					jsQuesion.setOptionNumber(option_num);
					jsQuesion.setAnswer(answer);
					list.add(jsQuesion);
				}
//		System.out.println(list.size());
		return list;
		
	}
}
