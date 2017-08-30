package cm.cn.mapper;

import java.util.List;

import cm.cn.po.StuDoneQues;

public interface QuestionStuMapper {
	public int delStuQues(String[] array);
	public List<StuDoneQues> selStuDeonQues();
}
