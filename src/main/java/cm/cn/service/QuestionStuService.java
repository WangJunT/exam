package cm.cn.service;

import java.util.List;

import cm.cn.po.JsQuestionStu;

public interface QuestionStuService {
	//���Ȳ�ѯ���ݿ��Ƿ��и�ѧ���������¼������в�ѯ�ϴ������¼,û�����ͷ��ʼ����������½��㣬
	//Ҳ�������˳�ʱ�Ƚ��ϴ����������������������£�С����ֱ���˳�
	public List<JsQuestionStu> selectIfExit(int id);
	//������ݿ�û�и�ѧ�������¼����¼ʱ����ҳ��ʼ���˳�ʱ��ѧ���������ط���¼,���嵽���ݿ���
	public int insertRecord(JsQuestionStu jsQuestionStu);
	//�˳�ʱ��ѧ���ϴ������¼��Ƚϣ���������ģ�С���򲻹ܡ�
}
