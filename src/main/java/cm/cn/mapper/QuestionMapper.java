package cm.cn.mapper;

import java.util.List;

import cm.cn.po.JsQuesion;

public interface QuestionMapper {
	//批量插入题
	public int insertList(List<JsQuesion> list); 
	//查询所有的题目(不包括简单题)
	public List<JsQuesion> selectAllQuestion();
	/**
	 * 随机查询单类题目
	 * @param type_id 1单选2多选3判断,不能由用户填写
	 * @param begin	随机数
	 * @param total 想获取题目的总数（由用户填写）
	 * @return
	 */
	public List<JsQuesion> selectRandomQuestion(int type_id,int begin,int total);
	//根据题目类别查询各种类别题目总数
	public int selectCount(int type_id);
	//分类别查询所有题目
	public List<JsQuesion> selectTypeQuestion(int type_id);
	//根据主键 id 数组查询答案
	public List<String> selectAnswer(String[] array);
}
