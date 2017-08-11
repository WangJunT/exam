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
	/**
	 * 随机查询单类题目
	 * @param type_id 1单选2多选3判断,不能由用户填写
	 * @param begin	随机数
	 * @param total 想获取题目的总数（由用户填写）
	 * @return
	 */
	public List<JsQuesion> selectRandomQuestion(int type_id,int total);
	//根据题目类别查询各种类别题目总数
	public int selectCount(int type_id);
	//分类别查询所有题目
	public List<JsQuesion> selectTypeQuestion(int type_id);
	//根据主键查询题目
	public JsQuesion selectQuePrimary(int id);
	//根据主键 id 数组查询答案
	public List<String> selectAnswer(String[] array);
	/**
	 * 
	 * @param ques_type 题目类型（1单选2多选3判断）
	 * @param  difficult_type难度程度（1易2中3难）
	 * @return
	 */
	public List<JsQuesion> selectQues(int ques_type,int difficult_type);

	//根据主键 id 查询JsQuestion
	public List<JsQuesion> selectJsQuestion(String[] array);
	//分页查询
	public List<JsQuesion> selectJsQuestionlimit(PageQuestion pageQuestion);
	//随机选题
	public List<JsQuesion> selectRan(RandomQuestion randomQuestion);
}
