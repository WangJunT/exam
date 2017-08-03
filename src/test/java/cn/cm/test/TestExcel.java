package cn.cm.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cm.cn.mapper.QuestionMapper;
import cm.cn.util.ExcelUtil;

public class TestExcel {
	
	@Autowired QuestionMapper questionMapper;
	@Test
	public void testExcel() throws Exception {
		String filePath = "C:\\Users\\dnd\\Documents\\WeChat Files\\wxid_5xxl7t4xw9ws22\\Files\\ต็นค.xlsx";
		List list = ExcelUtil.excelToQues(filePath);
		questionMapper.insertList(list);
	}
}
