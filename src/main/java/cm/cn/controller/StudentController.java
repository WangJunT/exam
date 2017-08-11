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
import cm.cn.util.StuExcelUtil;

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
		List<JsUser> list = StuExcelUtil.excelToStu(filePath);
		if (list.size()>0) {
			if (studentService.insertStuList(list)>0){
				map.put(0, "上传成功");
			}
			else{
				map.put(1, "添加失败，请参照模板上传");
			}
		}
		else{
			map.put(2, "文件未上传成功,请仔细检查文件格式");
		}
		
		return map;
	}
}
