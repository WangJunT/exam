package cm.cn.mapper;

import java.util.List;

import cm.cn.po.StuDoneExam;

public interface ExampaperStuMapper {
	public int delByExamIdArray(String[] arrays);
	public List<StuDoneExam> selDone(int stuid);
	public List<StuDoneExam> selStuDone();
	public int delByStuIdArray(String[] arrays);
}
