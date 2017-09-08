package cm.cn.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cm.cn.po.JsExampaper;
import cm.cn.po.JsQuesion;
import cm.cn.po.JsUser;
import cm.cn.po.JsVideo;
import cm.cn.po.Page;
//import cm.cn.po.StuDoneExam;
import cm.cn.po.StuDoneQues;
import cm.cn.service.ExamPaperService;
import cm.cn.service.ExampaperStuService;
import cm.cn.service.QuestionService;
import cm.cn.service.QuestionStuService;
import cm.cn.service.StudentService;
import cm.cn.service.VideoService;
import cm.cn.util.Base64;

@Controller
@RequestMapping("/tea")
//老师查看各种信息
public class TeacherController {
	@Autowired
	QuestionStuService questionStuService;
	@Autowired
	QuestionService questionService;
	@Autowired
	StudentService studentService;
	@Autowired
	ExamPaperService examPaperService;
	@Autowired
	VideoService videoService;
	@Autowired
	ExampaperStuService exampaperStuService;
	//按层级查询视屏信息
	@RequestMapping("/selVideo")
	@ResponseBody
	public Page<JsVideo> selVideo(int current,int pageSize,String reserveFive,String reserveSix){
		List<JsVideo> list = videoService.allVideo(reserveFive,reserveSix);
		Page<JsVideo> page= null;
		if (list.size()>0){
			page= new Page<JsVideo>(current, pageSize,list);
			return page;
		}
		else{
			return null ;
		}
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
		Page<JsQuesion> page= null;
		if (list.size()>0) {
			page= new Page<JsQuesion>(current, pageSize,list);
			return page;
		}
		else{
			return null;
		}
	}
	//按层级查看试卷信息
	@RequestMapping("/selExam")
	@ResponseBody
	public Page<JsExampaper> selExam(int current,int pageSize,String reserveFive,String reserveSix){
		List<JsExampaper> list = examPaperService.selectAll(reserveFive, reserveSix);
		Page<JsExampaper> page= null;
		if (list.size()>0) {
			page= new Page<JsExampaper>(current, pageSize,list);
			return page;
		}
		else{
			return null;
		}
	}
	//按层级查看学生考试信息
//	@RequestMapping
//	@ResponseBody
//	public Page<StuDoneExam> selStuExam(int current,int pageSize,String reserveFive,String reserveSix){
//		List<StuDoneExam> list = exampaperStuService.selExamStu();
//		Page<StuDoneExam> page= null;
//		if (list.size()>0) {
//			page= new Page<StuDoneExam>(current, pageSize,list);
//			return page;
//		}
//		else{
//			return null;
//		}
//	}
	//查看学生做题信息
	@RequestMapping("/selStuQues")
	@ResponseBody
	public Page<StuDoneQues> selStuQues(int current,int pageSize){
		List<StuDoneQues> list = questionStuService.selStuDeonQues();
		Page<StuDoneQues> page= null;
		if (list.size()>0) {
			page= new Page<StuDoneQues>(current, pageSize,list);
			return page;
		}
		else{
			return null;
		}
	}
	//更改学生做题信息
	@RequestMapping("/upStuInfo")
	@ResponseBody
	public int upStuInfo(@RequestBody JsUser record){
        return studentService.updateStuInfo(record);
	}
	//单个添加学生
	@RequestMapping("/insertStu")
	@ResponseBody
	public int insertStu(@RequestBody JsUser record){
		String password = Base64.encode(("zjedu"+record.getPassword()+"cn").getBytes());
		record.setPassword(password);
		return studentService.insertStu(record);
	}
	//更改题目信息
	@RequestMapping("/updateQues")
	@ResponseBody
	public int updateQues(@RequestBody JsQuesion record){
		return questionService.updateByid(record);
	}
	//查看学生考试信息 
	
}
