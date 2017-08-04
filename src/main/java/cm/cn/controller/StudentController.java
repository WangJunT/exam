package cm.cn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cm.cn.po.JsUser;
import cm.cn.service.StudentService;
import cm.cn.util.ExcelUtil;

@Controller
@RequestMapping("/stu")
public class StudentController {
	@Autowired
	StudentService studentService;
	@RequestMapping("/addStuBatch")
	@ResponseBody
	public Map<Integer, String> addStuBatch(){
		Map<Integer, String> map = new HashMap<>();
		String filePath = "C:\\Users\\dnd\\Desktop\\学生信息.xlsx";
		List<JsUser> list = ExcelUtil.excelToStu(filePath);
		if (studentService.insertStuList(list)>0){
			map.put(0, "success");
		}
		else{
			map.put(1, "fail");
		}
		return map;
	}
}
