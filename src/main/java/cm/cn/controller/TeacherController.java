package cm.cn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cm.cn.po.JsExampaper;
import cm.cn.po.JsQuesion;
import cm.cn.po.JsUser;
import cm.cn.po.JsVideo;
import cm.cn.po.Page;
import cm.cn.service.ExamPaperService;
import cm.cn.service.QuestionService;
import cm.cn.service.StudentService;
import cm.cn.service.VideoService;

@Controller
@RequestMapping("/tea")
public class TeacherController {
	@Autowired
	QuestionService questionService;
	@Autowired
	StudentService studentService;
	@Autowired
	ExamPaperService examPaperService;
	@Autowired
	VideoService videoService;
	//按层级查询视屏信息
	@RequestMapping("/selVideo")
	@ResponseBody
	public Page<JsVideo> selVideo(int current,int pageSize,String reserveFive,String reserveSix){
		List<JsVideo> list = videoService.allVideo(reserveFive,reserveSix);
		Page<JsVideo> page= new Page<JsVideo>(current, pageSize,list);
		return page;
	}
	//按层级查看学生信息
	@RequestMapping("/selStu")
	@ResponseBody
	public Page<JsUser> selStu(int current,int pageSize,String reserveFive,String reserveSix){
		List<JsUser> list = studentService.selectAll(reserveFive, reserveSix);
		Page<JsUser> page = null;
		if (list.size()>0) {
			page= new Page<JsUser>(current, pageSize,list);
			return page;
		}
		else{
			return null;
		}
	}
	//老师查询所有题目，可根据层级单位查询
	@RequestMapping("/selQues")
	@ResponseBody
	public Page<JsQuesion> selQues(int current,int pageSize,String reserveFive,String reserveSix){
		List<JsQuesion> list = questionService.selectAllQuestion(reserveFive,reserveSix);;
		Page<JsQuesion> page= new Page<JsQuesion>(current, pageSize,list);
		return page;
	}
	//按层级查看试卷信息
	@RequestMapping("/selExam")
	@ResponseBody
	public Page<JsExampaper> selExam(int current,int pageSize,String reserveFive,String reserveSix){
		List<JsExampaper> list = examPaperService.selectAll(reserveFive, reserveSix);
		Page<JsExampaper> page= new Page<JsExampaper>(current, pageSize,list);
		return page;
	}
	//按层级查看学生考试信息
//	@RequestMapping
//	@ResponseBody
//	public List<JsExampaper> selStuExam(String reserveFive,String reserveSix){
//		return examPaperService.selectAll(reserveFive, reserveSix);
//	}
	//查看学生做题信息
}
