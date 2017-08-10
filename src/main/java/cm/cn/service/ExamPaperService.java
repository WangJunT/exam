package cm.cn.service;

import java.util.List;

import cm.cn.po.JsExampaper;

public interface ExamPaperService {
	//随机组卷
	public int addExamPaper(JsExampaper jsExampaper);
	//查看所有试卷
	public List<JsExampaper> selectAll();
	//考试(传给前段所有题目,答案)
	public JsExampaper selectById(int id);
}
