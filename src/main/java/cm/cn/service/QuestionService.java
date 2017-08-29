package cm.cn.service;

import java.util.List;

import cm.cn.po.JsQuesion;
import cm.cn.po.PageQuestion;
import cm.cn.po.RandomQuestion;
import cm.cn.po.StuDoneQues;

public interface QuestionService {
	//批量插入题目（除简答题）
	public int insertList(List<JsQuesion> list);
	//老师查看所有的题目（老师可按层级来查看）、学生做顺序练习
	public List<JsQuesion> selectAllQuestion(String reserveFive,String reserveSix);
	//根据主键查询题目
	public JsQuesion selectQuePrimary(int id);
	//根据主键 id 数组查询答案
	public List<String> selectAnswer(String[] array);
	//根据主键 id 查询JsQuestion
	public List<JsQuesion> selectJsQuestion(String[] array);
	//分页查询
	public List<JsQuesion> selectJsQuestionlimit(PageQuestion pageQuestion);
	//随机选题(教师在组卷时选择对应单位)
	public List<JsQuesion> selectRan(RandomQuestion randomQuestion);
	//删除试题
	public int delQues(int id);
	//学生做题总数信息
	public List<StuDoneQues> selStuDeonQues();
	//添加批量删除
	public int delQuesBatch(String[] array);
}
