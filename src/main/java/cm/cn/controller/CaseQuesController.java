package cm.cn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
