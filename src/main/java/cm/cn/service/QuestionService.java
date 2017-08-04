package cm.cn.service;

import java.util.List;

import cm.cn.po.JsQuesion;

public interface QuestionService {
	//����������Ŀ��������⣩
	public int insertList(List<JsQuesion> list);
	//�鿴���е���Ŀ��������⣩
	public List<JsQuesion> selectAllQuestion();
	/**
	 * �����ѯ������Ŀ
	 * @param type_id 1��ѡ2��ѡ3�ж�,�������û���д
	 * @param begin	�����
	 * @param total ���ȡ��Ŀ�����������û���д��
	 * @return
	 */
	public List<JsQuesion> selectRandomQuestion(int type_id,int total);
	//������Ŀ����ѯ���������Ŀ����
	public int selectCount(int type_id);
	//������ѯ������Ŀ
	public List<JsQuesion> selectTypeQuestion(int type_id);
	//����������ѯ��Ŀ
	public JsQuesion selectQuePrimary(int id);
	//�������� id �����ѯ��
	public List<String> selectAnswer(String[] array);
	/**
	 * 
	 * @param ques_type ��Ŀ���ͣ�1��ѡ2��ѡ3�жϣ�
	 * @param difficult_type�Ѷȳ̶ȣ�1��2��3�ѣ�
	 * @return
	 */
	public List<JsQuesion> selectQues(int ques_type,int difficult_type);
}
