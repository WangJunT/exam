package cm.cn.service;

import java.util.List;

import cm.cn.po.JsExampaperStu;

public interface ExampaperStuService {
	//�鿴��ǰ�ÿ����Ƿ��Թ��ÿ�Ŀ
	public List<JsExampaperStu> selectIfExam(JsExampaperStu examStu);
	//���ѧ��������Ϣ
	public int insertStuExam(JsExampaperStu examStu);
	//������������ѧ��������Ϣ
	public int updateStuExam(JsExampaperStu examStu);
	//��ɾ���Ծ�ʱ��ɾ����֮�йصĿ�����Ϣ
	public int delStuExam();
}
