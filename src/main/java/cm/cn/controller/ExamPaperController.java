package cm.cn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cm.cn.po.JsExampaper;
import cm.cn.service.ExamPaperService;
import cm.cn.service.QuestionService;
import cm.cn.util.RandomAndSpiltUtil;

@Controller
@RequestMapping("/exam")
public class ExamPaperController {
	@Autowired
	QuestionService questionService;
	@Autowired
	ExamPaperService examPaperService;
	@RequestMapping("/addExam")
	@ResponseBody
	public Map<Integer, String> addQuestion(){
		Map<Integer, String> map = new HashMap<>();
		String o = "1,2,3,4,5";
		String[] one_array = RandomAndSpiltUtil.strToArray(o);
		//String one_id,String more_id,String judge
//		String[] more_array = RandomAndSpiltUtil.strToArray(more_id);
//		String[] judge_array = RandomAndSpiltUtil.strToArray(judge);
		List<String> answer_one = questionService.selectAnswer(one_array);
//		List<String> answer_more = questionService.selectAnswer(more_array);
//		List<String> answer_judge = questionService.selectAnswer(judge_array);
		JsExampaper jsExampaper = new JsExampaper();
		jsExampaper.setSelectOne(o);
		jsExampaper.setAnswerOne(RandomAndSpiltUtil.arrayToStr(RandomAndSpiltUtil.listtoStr(answer_one)));
		if(examPaperService.addExamPaper(jsExampaper)>0){
			map.put(0,"success");
		}
		else {
			map.put(1, "fail");
		}
		return map;
	}
//	@RequestMapping("/Exam")
//	@ResponseBody
//	public List<String> adQuestion(){
//		String judge = "1,2,3,4,5";
//		String[] judge_array = RandomAndSpiltUtil.toSArray(judge);
//		return ;
//		
//	}
}
