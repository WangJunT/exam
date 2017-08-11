package cm.cn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cm.cn.po.CaseAndQuestion;
import cm.cn.po.JsCase;
import cm.cn.service.CaseQuestionService;

@Controller
@RequestMapping("/caseQues")
public class CaseQuesController {
	@Autowired
	CaseQuestionService caseQuestionservie;
	@RequestMapping("/allCase")
	@ResponseBody
	public List<JsCase> allCase(){
		return caseQuestionservie.selectAll();
	}
	@RequestMapping("/selectCase")
	@ResponseBody
	public CaseAndQuestion selectCase(int id){
		return caseQuestionservie.selectCase(id);
	}
	@RequestMapping("/selectCaseAndQues")
	@ResponseBody
	public List<CaseAndQuestion> selectCaseAndQues(String[] array){
		List<CaseAndQuestion> list = caseQuestionservie.selectCaseAndQues(array);
		return list;
	}
}
