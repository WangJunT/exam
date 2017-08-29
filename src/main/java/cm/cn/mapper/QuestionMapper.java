package cm.cn.mapper;

import java.util.List;

import cm.cn.po.JsQuesion;
import cm.cn.po.PageQuestion;
import cm.cn.po.RandomQuestion;
import cm.cn.po.StuDoneQues;

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
	//学生做题总数信息
	public List<StuDoneQues> selStuDeonQues();
	//根据 ID 批量删除题目
	public int delQuesBatch(String[] array);
}
