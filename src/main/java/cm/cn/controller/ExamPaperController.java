package cm.cn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cm.cn.po.JsExampaper;
import cm.cn.po.JsQuesion;
import cm.cn.po.JsUser;
import cm.cn.service.ExamPaperService;
import cm.cn.service.QuestionService;
import cm.cn.util.ListTransfrom;
import cm.cn.util.RandomAndSpiltUtil;

@Controller
@RequestMapping("/exam")
public class ExamPaperController {
	@Autowired
	QuestionService questionService;
	@Autowired
	ExamPaperService examPaperService;
	@RequestMapping(value="/addExam",method=RequestMethod.POST)
	@ResponseBody
	public Map<Integer, String> addQuestion(@RequestBody JsExampaper jsExampaper){
		Map<Integer, String> map = new HashMap<>();
		List<JsQuesion> select_one = questionService.selectRandomQuestion(1, jsExampaper.getSelectOneNum());
		List<JsQuesion> select_more = questionService.selectRandomQuestion(2, jsExampaper.getSelectMoreNum());
		List<JsQuesion> judge = questionService.selectRandomQuestion(3, jsExampaper.getSelectJudgeNum());
		String select_one_questionId = RandomAndSpiltUtil.arrayToStr(ListTransfrom.listQuestionToArray(select_one, 1));
		String select_one_questionAnswer = RandomAndSpiltUtil.arrayToStr(ListTransfrom.listQuestionToArray(select_one, 2));
		String select_more_questionId = RandomAndSpiltUtil.arrayToStr(ListTransfrom.listQuestionToArray(select_more, 1));
		String select_more_questionAnswer = RandomAndSpiltUtil.arrayToStr(ListTransfrom.listQuestionToArray(select_more, 2));
		String judge_questionId = RandomAndSpiltUtil.arrayToStr(ListTransfrom.listQuestionToArray(judge, 1));
		String judge_questionAnswer = RandomAndSpiltUtil.arrayToStr(ListTransfrom.listQuestionToArray(judge, 2));
		jsExampaper.setSelectOne(select_one_questionId);
		jsExampaper.setAnswerOne(select_one_questionAnswer);
		jsExampaper.setSelectMore(select_more_questionId);
		jsExampaper.setAnswerMore(select_more_questionAnswer);
		jsExampaper.setJudge(judge_questionId);
		jsExampaper.setAnswerJudge(judge_questionAnswer);
		if(examPaperService.addExamPaper(jsExampaper)>0){
			map.put(0,"success");
		}
		else {
			map.put(1, "fail");
		}
		return map;
	}
	@RequestMapping(value="/selectAll")
	@ResponseBody
	public List<JsExampaper> selectAll(){
		List<JsExampaper> list = examPaperService.selectAll();
		return list;
	}
	@RequestMapping(value="/beginExam")
	@ResponseBody
	public Map<Integer, List<JsQuesion>> beginExam(int id){
		Map<Integer,List<JsQuesion>> map = new HashMap<>();
		JsExampaper jsExampaper = examPaperService.selectById(id);
		String[] selectOneid = RandomAndSpiltUtil.strToArray(jsExampaper.getSelectOne());
		List<JsQuesion> selectOnelist = questionService.selectJsQuestion(selectOneid);
		map.put(0, selectOnelist);
		String[] selectMoreid = RandomAndSpiltUtil.strToArray(jsExampaper.getSelectMore());
		List<JsQuesion> selectMorelist = questionService.selectJsQuestion(selectMoreid);
		map.put(2, selectMorelist);
		String[] judge = RandomAndSpiltUtil.strToArray(jsExampaper.getJudge());
		List<JsQuesion> selectJudgelist = questionService.selectJsQuestion(judge);
		map.put(3, selectJudgelist);
		return map;
	}
}
