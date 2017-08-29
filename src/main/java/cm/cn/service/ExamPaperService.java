package cm.cn.service;

import java.util.List;

import cm.cn.po.JsExampaper;

public interface ExamPaperService {
	//随机组卷
	public int addExamPaper(JsExampaper jsExampaper);
	//查看所有试卷
	public List<JsExampaper> selectAll(String reserveFive,String reserveSix);
	//考试(传给前段所有题目,答案)
	public JsExampaper selectById(int id);
	//	删除试卷
	public int delExam(String[] intarray);
	//单个删除试卷
	public int delExam(int id);
	//根据 层级查询试卷 id 数组
	public List<String> findByLevel(String reserveSix);
}
