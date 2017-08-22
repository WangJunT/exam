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

import cm.cn.po.CaseAndQuestion;
import cm.cn.po.JsExampaper;
import cm.cn.po.JsQuesion;
import cm.cn.po.RandomQuestion;
import cm.cn.service.CaseQuestionService;
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
	@Autowired
	CaseQuestionService caseQuestionService;
	//随机组卷
	@RequestMapping(value="/addExam",method=RequestMethod.POST)
	@ResponseBody
	public Map<Integer, String> addQuestion(@RequestBody JsExampaper jsExampaper){
		Map<Integer, String> map = new HashMap<>();
		RandomQuestion randomQuestion = new RandomQuestion();
		int selectOneNum=jsExampaper.getSelectOneNum();
		if (selectOneNum>0) {
			randomQuestion.setTypeId(1);
			randomQuestion.setTotal(selectOneNum);
			List<JsQuesion> select_one = questionService.selectRan(randomQuestion);
			String select_one_questionId = RandomAndSpiltUtil.arrayToStr(ListTransfrom.listQuestionToArray(select_one, 1));
			String select_one_questionAnswer = RandomAndSpiltUtil.arrayToStr(ListTransfrom.listQuestionToArray(select_one, 2));
			jsExampaper.setSelectOne(select_one_questionId);
			jsExampaper.setAnswerOne(select_one_questionAnswer);
		}
		int selectMoreNum=jsExampaper.getSelectMoreNum();
		if (selectMoreNum>0) {
			randomQuestion.setTypeId(2);
			randomQuestion.setTotal(selectMoreNum);
			List<JsQuesion> select_more = questionService.selectRan(randomQuestion);
			String select_more_questionId = RandomAndSpiltUtil.arrayToStr(ListTransfrom.listQuestionToArray(select_more, 1));
			String select_more_questionAnswer = RandomAndSpiltUtil.arrayToStr(ListTransfrom.listQuestionToArray(select_more, 2));
			jsExampaper.setSelectMore(select_more_questionId);
			jsExampaper.setAnswerMore(select_more_questionAnswer);
		}
		int judgeNum=jsExampaper.getSelectJudgeNum();
		if (judgeNum>0) {
			randomQuestion.setTypeId(3);
			randomQuestion.setTotal(judgeNum);
			List<JsQuesion> judge = questionService.selectRan(randomQuestion);
			String judge_questionId = RandomAndSpiltUtil.arrayToStr(ListTransfrom.listQuestionToArray(judge, 1));
			String judge_questionAnswer = RandomAndSpiltUtil.arrayToStr(ListTransfrom.listQuestionToArray(judge, 2));
			jsExampaper.setJudge(judge_questionId);
			jsExampaper.setAnswerJudge(judge_questionAnswer);
		}
//		int caseNum=jsExampaper.getCasequesNum();
//		if (caseNum>0) {
//			
//		}
		if(examPaperService.addExamPaper(jsExampaper)>0){
			map.put(0,"success");
		}
		else {
			map.put(1, "fail");
		}
		return map;
	}
	//手动组卷（未完成）------------------------------------------
	@RequestMapping(value="addExamByhand")
	@ResponseBody
	public Map<Integer, String> addExamByhand(@RequestBody JsExampaper jsExampaper){
		Map<Integer, String> map = new HashMap<>();
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
	public Map<Integer, Object> beginExam(int id){
		Map<Integer,Object> map = new HashMap<>();
		JsExampaper jsExampaper = examPaperService.selectById(id);
		String selectOne = jsExampaper.getSelectOne();
		if (selectOne!=null) {
			String[] selectOneid = RandomAndSpiltUtil.strToArray(selectOne);
			List<JsQuesion> selectOnelist = questionService.selectJsQuestion(selectOneid);
			map.put(0, selectOnelist);
			map.put(4, jsExampaper.getSelectOneScore());
		}
		String selectMore = jsExampaper.getSelectMore();
		if (selectMore!=null) {
			String[] selectMoreid = RandomAndSpiltUtil.strToArray(selectMore);
			List<JsQuesion> selectMorelist = questionService.selectJsQuestion(selectMoreid);
			map.put(1, selectMorelist);
			map.put(5, jsExampaper.getSelectMoreScore());
		}
		String judges = jsExampaper.getJudge();
		if (judges!=null){
			String[] judge = RandomAndSpiltUtil.strToArray(judges);
			List<JsQuesion> selectJudgelist = questionService.selectJsQuestion(judge);
			map.put(2, selectJudgelist);
			map.put(6, jsExampaper.getSelectJudgeScore());
		}
		String caseStr = jsExampaper.getCaseques();
		if(caseStr!=null){
			String caseArray[] = RandomAndSpiltUtil.strToArray(caseStr);
			List<CaseAndQuestion> caseQues = caseQuestionService.selectCaseAndQues(caseArray);
			map.put(3, caseQues);
			map.put(7, jsExampaper.getCasequesNum());
		}
		return map;
	}
	@RequestMapping(value="/delExam")
	@ResponseBody
	public Map<Integer, Object> delExam(int[] intarray){
		Map<Integer,Object> map = new HashMap<>();
		//先删除与之关联的试卷学生关系
		int num = examPaperService.delExam(intarray);
		if (num>0) {
			map.put(0, "删除"+num+"条数据");
		}
		else{
			map.put(1, "删除失败");
		}
		return map;
	}
}
