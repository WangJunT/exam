package cm.cn.service;

import java.util.List;

import cm.cn.po.CaseAndQuestion;
import cm.cn.po.JsCase;
import cm.cn.po.JsCasequestion;

public interface CaseQuestionService {
	//插入简答题
	public int insertCase(JsCase jsCase);
	//插入简答题的子题目
	public int insertZiQues(JsCasequestion jsCasequestion);
	//单独显示所有简答题（只包括题干）
	public List<JsCase> selectAll();
	//显示一道简单题
	public CaseAndQuestion selectCase(int id);
	//根据主键 id 查询简答题和它的子题目
	public List<CaseAndQuestion> selectCaseAndQues(String[] array);
}
