package cm.cn.mapper;

import java.util.List;

import cm.cn.po.JsQuesion;
import cm.cn.po.PageQuestion;
import cm.cn.po.RandomQuestion;

public interface QuestionMapper {
	//批量插入题
	public int insertList(List<JsQuesion> list); 
	//查询所有的题目(不包括简单题)
	public List<JsQuesion> selectAllQuestion();
	//根据主键 id 数组查询答案selectJsQuestion
	public List<String> selectAnswer(String[] array);
	//根据主键 id 查询JsQuestion
	public List<JsQuesion> selectJsQuestion(String[] array);
	//分页查询
	public List<JsQuesion> selectJsQuestionlimit(PageQuestion pageQuestion);
	//随机查询题目
	public List<JsQuesion> selectRan(RandomQuestion randomQuestion);
}
