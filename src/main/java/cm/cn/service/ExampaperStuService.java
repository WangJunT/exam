package cm.cn.service;

import java.util.List;

import cm.cn.po.JsExampaperStu;
import cm.cn.po.StuDoneExam;

public interface ExampaperStuService {
	//查看先前该考生是否考试过该科目
	public List<JsExampaperStu> selectIfExam(JsExampaperStu examStu);
	//添加学生考试信息
	public int insertStuExam(JsExampaperStu examStu);
	//如果存在则更改学生考试信息
	public int updateStuExam(JsExampaperStu examStu);
	//当删除试卷时，删除与之有关的考试信息
//	public int delStuExam(int[] arrays);
	//查看当前学生做试卷情况
	public List<StuDoneExam> seleDone(int stuid); 
	//老师分层级查看学生考试信息
	public List<StuDoneExam> selExamStu();
//	public List<StuDoneExam> selExamStu(String reserveFive,String reserveSix);
	public int delStuDoneExam(int id);
}
