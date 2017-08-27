package cm.cn.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cm.cn.service.ExamPaperService;
import cm.cn.service.QuestionService;
import cm.cn.service.StudentService;
import cm.cn.service.VideoService;
@Controller
@RequestMapping("/tea")
public class TeacherDelController {
	
	//删除视屏
	@Autowired
	QuestionService questionService;
	@Autowired
	StudentService studentService;
	@Autowired
	ExamPaperService examPaperService;
	@Autowired
	VideoService videoService;
	//删除学生信息
	@RequestMapping("/delStu")
	@ResponseBody
	public Map<Integer, Object> delStu(int id){
		Map<Integer,Object> map = new HashMap<>();
		int num = studentService.delStu(id);
		if (num>0) {
			map.put(0, "删除成功");
		}
		else{
			map.put(1, "删除失败");
		}
		return map;
	}
	//删除题目
	@RequestMapping("/delQues")
	@ResponseBody
	public Map<Integer, Object> delQues(int id){
		Map<Integer,Object> map = new HashMap<>();
		int num = questionService.delQues(id);
		if (num>0) {
			map.put(0, "删除成功");
		}
		else{
			map.put(1, "删除失败");
		}
		return map;
	}
	//删除试卷
	@RequestMapping("/delExam")
	@ResponseBody
	public Map<Integer, Object> delExam(int id){
		Map<Integer,Object> map = new HashMap<>();
		int num = examPaperService.delExam(id);
		if (num>0) {
			map.put(0, "删除成功");
		}
		else{
			map.put(1, "删除失败");
		}
		return map;
	}
}
