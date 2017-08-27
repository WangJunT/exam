package cm.cn.service;

import java.util.List;

import cm.cn.po.JsExampaperStu;
import cm.cn.po.StuDoneExam;

public interface ExampaperStuService {
	//�鿴��ǰ�ÿ����Ƿ��Թ��ÿ�Ŀ
	public List<JsExampaperStu> selectIfExam(JsExampaperStu examStu);
	//���ѧ��������Ϣ
	public int insertStuExam(JsExampaperStu examStu);
	//������������ѧ��������Ϣ
	public int updateStuExam(JsExampaperStu examStu);
	//��ɾ���Ծ�ʱ��ɾ����֮�йصĿ�����Ϣ
//	public int delStuExam(int[] arrays);
	//�鿴��ǰѧ�����Ծ����
	public List<StuDoneExam> seleDone(int stuid); 
	//��ʦ�ֲ㼶�鿴ѧ��������Ϣ
	public List<StuDoneExam> selExamStu();
//	public List<StuDoneExam> selExamStu(String reserveFive,String reserveSix);
	public int delStuDoneExam(int id);
}
