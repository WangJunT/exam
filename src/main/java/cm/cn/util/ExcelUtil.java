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
//		System.out.println(list.size());
		return list;
		
	}
}
