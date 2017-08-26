package cm.cn.serviceImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.cn.po.JsCase;
import cm.cn.po.JsCasequestion;
import cm.cn.service.CaseQuestionService;
import cm.cn.service.UpCaseQues;
@Service
public class UpCaseQuesImpl implements UpCaseQues {

	@Autowired
	CaseQuestionService caseQuestionService;
	/**
	 * 导入第三张表
	 */
	@Override
	public void excelToJsCase(String path,String reserveFive,String reserveSix) {
		FileInputStream excelFileInputStream;
		String filetype = path.substring(path.lastIndexOf(".") + 1);
		if ("xls".equals(filetype.toLowerCase())) {
			HSSFWorkbook workbook = null;
			try {
				excelFileInputStream = new FileInputStream(path);
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
			int id = 0;
			for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				HSSFRow row = sheet.getRow(rowIndex);
				if (row == null) {
					continue;
				}
				if ((row.getCell(0).getStringCellValue()).contains("、")) {
					jsCasequestion  = new JsCasequestion();
//					String case_id = row.getCell(1).getCellFormula();
					String content = row.getCell(1).getStringCellValue();//题干
					jsCasequestion.setContent(content);
					String an_A = row.getCell(2).getStringCellValue();
					jsCasequestion.setAnA(an_A);
					String an_B = row.getCell(3).getStringCellValue();
					jsCasequestion.setAnB(an_B);
					String an_C = row.getCell(4).getStringCellValue();
					jsCasequestion.setAnC(an_C);
					String an_D = row.getCell(5).getStringCellValue();
					jsCasequestion.setAnD(an_D);
					if (row.getCell(6)!=null){
						String an_E = row.getCell(6).getStringCellValue();
						jsCasequestion.setAnE(an_E);
					}
					String answer = row.getCell(7).getStringCellValue();
					jsCasequestion.setAnswer(answer);
					jsCasequestion.setCaseId(id);
					caseQuestionService.insertZiQues(jsCasequestion);
				}else{
					jsCase = new JsCase();
					String content = row.getCell(1).getStringCellValue();
					jsCase.setContent(content);
					//-------------------------------------------------------------
					jsCase.setReserveFive(reserveFive);
					jsCase.setReserveSix(reserveSix);
					caseQuestionService.insertCase(jsCase);
					id = jsCase.getId();
				}
			}
		}
		if("xlsx".equals(filetype.toLowerCase())) {
			XSSFWorkbook workbook = null;
			try {
				excelFileInputStream = new FileInputStream(path);
				workbook = new XSSFWorkbook(excelFileInputStream);
				excelFileInputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
			XSSFSheet sheet = workbook.getSheetAt(3);
			JsCase jsCase = null;
			JsCasequestion jsCasequestion = null;
			int id = 0;
			for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				XSSFRow row = sheet.getRow(rowIndex);
				if (row == null) {
					continue;
				}
				if ((row.getCell(0).getStringCellValue()).contains("、")) {
					jsCasequestion  = new JsCasequestion();
//					String case_id = row.getCell(1).getCellFormula();
					String content = row.getCell(1).getStringCellValue();//题干
					jsCasequestion.setContent(content);
					String an_A = row.getCell(2).getStringCellValue();
					jsCasequestion.setAnA(an_A);
					String an_B = row.getCell(3).getStringCellValue();
					jsCasequestion.setAnB(an_B);
					String an_C = row.getCell(4).getStringCellValue();
					jsCasequestion.setAnC(an_C);
					String an_D = row.getCell(5).getStringCellValue();
					jsCasequestion.setAnD(an_D);
					if (row.getCell(6)!=null){
						String an_E = row.getCell(6).getStringCellValue();
						jsCasequestion.setAnE(an_E);
					}
					String answer = row.getCell(7).getStringCellValue();
					jsCasequestion.setAnswer(answer);
					jsCasequestion.setCaseId(id);
					caseQuestionService.insertZiQues(jsCasequestion);
				}else{
					jsCase = new JsCase();
					String content = row.getCell(1).getStringCellValue();
					jsCase.setContent(content);
					jsCase.setReserveFive(reserveFive);
					jsCase.setReserveSix(reserveSix);
					caseQuestionService.insertCase(jsCase);
					id = jsCase.getId();
				}
			}
		
		}
	}

}
