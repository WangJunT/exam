package cm.cn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cm.cn.po.JsQuesion;
import cm.cn.service.QuestionService;
import cm.cn.util.ExcelUtil;

@Controller
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@RequestMapping("/test")
	@ResponseBody
	public int s(){
		String filePath = "C:\\Users\\dnd\\Documents\\WeChat Files\\wxid_5xxl7t4xw9ws22\\Files\\电工.xlsx";
		List<JsQuesion> list = ExcelUtil.excelToQues(filePath);
		return questionService.insertList(list);
	}
	@RequestMapping("/selectAllQues")
	@ResponseBody
	public List<JsQuesion> selectAllQues(){
		List<JsQuesion> list = questionService.selectAllQuestion();
		return list;
	}
	@RequestMapping("/selectCount")
	@ResponseBody
	public int selectCount(int type_id){
		int num = questionService.selectCount(type_id);
		return num;
	}
	@RequestMapping("/selectTypeQuestion")
	@ResponseBody
	public List<JsQuesion> selectTypeQuestion(int type_id){
		List<JsQuesion> list = questionService.selectTypeQuestion(type_id);
		return list;
	}
	@RequestMapping("/selectRandomQuestion")
	@ResponseBody
	public List<JsQuesion> selectRandomQuestion(int type_id,int begin,int total){
		List<JsQuesion> list = questionService.selectRandomQuestion(type_id,begin,total);
		return list;
	}
}
