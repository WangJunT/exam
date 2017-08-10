package cm.cn.service;

import java.util.List;

import cm.cn.po.JsCase;
import cm.cn.po.JsCasequestion;

public interface CaseQuestionService {
	//插入简答题
	public int insertCase(JsCase jsCase);
	//插入简答题的子题目
	public int insertZiQues(JsCasequestion jsCasequestion);
	//单独显示所有简答题（只包括题干）
	public List<JsCase> selectAll();
}
