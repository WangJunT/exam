package cm.cn.service;

import java.util.List;

import cm.cn.po.JsQuesion;
import cm.cn.po.PageQuestion;
import cm.cn.po.RandomQuestion;

public interface QuestionService {
	//批量插入题目（除简答题）
	public int insertList(List<JsQuesion> list);
	//查看所有的题目（除简答题）
	public List<JsQuesion> selectAllQuestion();
	//根据主键查询题目
	public JsQuesion selectQuePrimary(int id);
	//根据主键 id 数组查询答案
	public List<String> selectAnswer(String[] array);
	//根据主键 id 查询JsQuestion
	public List<JsQuesion> selectJsQuestion(String[] array);
	//分页查询
	public List<JsQuesion> selectJsQuestionlimit(PageQuestion pageQuestion);
	//随机选题
	public List<JsQuesion> selectRan(RandomQuestion randomQuestion);
	//查询各种类别试卷总数
	public int selAllCount(JsQuesion jsQuesion);
}
