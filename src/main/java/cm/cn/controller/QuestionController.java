package cm.cn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cm.cn.po.JsQuesion;
import cm.cn.po.JsQuestionStu;
import cm.cn.po.JsUser;
import cm.cn.po.PageQuestion;
import cm.cn.po.RandomQuestion;
import cm.cn.service.QuestionService;
import cm.cn.service.QuestionStuService;
import cm.cn.service.UpCaseQues;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionStuService questionStuService;
	@Autowired
	QuestionService questionService;
	@Autowired
	UpCaseQues upCaseQues;
	//学生查询对应工种题目，即顺序练习
	@RequestMapping("/selStuQues")
	@ResponseBody
	public List<JsQuesion> selStuQues(HttpSession session){
		JsUser user = (JsUser) session.getAttribute("user");
		return questionService.selectAllQuestion(user.getReserveFive(),user.getReserveSix());
	}
//	@RequestMapping("/orderPractice")
//	@ResponseBody
//	public Map<Integer, Object> orderPractice(PageQuestion pageQuestion,HttpSession session){
//		Map<Integer, Object> map = new HashMap<>();
//		JsUser jsUser = (JsUser) session.getAttribute("user");
//		List<JsQuestionStu> list1 = null;
//		JsQuestionStu jsQuestionStu = null;
//		int start = pageQuestion.getStart();
//		list1 = questionStuService.selectIfExit(jsUser.getId());
//		if (list1.size()>0) {
//			jsQuestionStu = list1.get(0);
//			start = jsQuestionStu.getTotal();
//			pageQuestion.setStart(start);
//		}
//		List<JsQuesion> list= questionService.selectJsQuestionlimit(pageQuestion);
//		map.put(0, start);
//		map.put(1, list);
//		return map;
//	}
	//进入顺序练习
	@RequestMapping("/orderPractice")
	@ResponseBody
	public Map<Integer, Object> orderPractice(HttpSession session){
		Map<Integer, Object> map = new HashMap<>();
		PageQuestion pageQuestion = new PageQuestion();
		JsUser jsUser = (JsUser) session.getAttribute("user");
		List<JsQuestionStu> list1 = null;
		JsQuestionStu jsQuestionStu = new JsQuestionStu();
		int start = 0;
		list1 = questionStuService.selectIfExit(jsUser.getId());
		if (list1.size()>0) {
			jsQuestionStu = list1.get(0);
			start = jsQuestionStu.getTotal();
		}
		pageQuestion.setStart(start);
		pageQuestion.setSize(10);;
		List<JsQuesion> list= questionService.selectJsQuestionlimit(pageQuestion);
		map.put(0, start);
		map.put(1, list);
		return map;
	}
	//分页显示
	@RequestMapping("/selectLimit")
	@ResponseBody
	public List<JsQuesion> selectLimit(PageQuestion pageQuestion,HttpSession session){
		List<JsQuesion> list= questionService.selectJsQuestionlimit(pageQuestion);
		return list;
	}
	//退出顺序练习
	@RequestMapping("/quitPractice")
	@ResponseBody
	public Map<Integer, String> quitPractice(int start,HttpSession session){
		Map<Integer, String> map = new HashMap<>();
		JsUser jsUser = (JsUser) session.getAttribute("user");
		List<JsQuestionStu> list1 = null;
		JsQuestionStu jsQuestionStu = new JsQuestionStu();
		list1 = questionStuService.selectIfExit(jsUser.getId());
		if (list1.size()>0) {
			jsQuestionStu = list1.get(0);
			if (start>jsQuestionStu.getTotal()) {
				jsQuestionStu.setTotal(start);
				questionStuService.updateRecord(jsQuestionStu);
			}
			else
				start = jsQuestionStu.getTotal();
		}else{
			jsQuestionStu.setStuId(jsUser.getId());
			jsQuestionStu.setTotal(start);
			questionStuService.insertRecord(jsQuestionStu);
		}
		map.put(0, "你一共做了"+start+"题");
		return map;
	}
	@RequestMapping("/selectRan")
	@ResponseBody
	public List<JsQuesion> selectRan(RandomQuestion randomQuestion){
		List<JsQuesion> list= questionService.selectRan(randomQuestion);
		System.out.println(list.size());
		return list;
	}
}
