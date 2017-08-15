package cm.cn.service;

import java.util.List;

import cm.cn.po.JsQuestionStu;

public interface QuestionStuService {
	//首先查询数据库是否有该学生的做题记录（如果有查询上次做题记录,没有则从头开始）可用作登陆起点，
	//也可用作退出时比较上次做题数量，如果大于则更新，小于则直接退出
	public List<JsQuestionStu> selectIfExit(int id);
	//如果数据库没有该学生做题记录，登录时从首页开始，退出时将学生最后做题地方记录,并插到数据库中
	public int insertRecord(JsQuestionStu jsQuestionStu);
	//退出时与学生上次做题记录相比较，大于则更改，小于则不管。
}
