package cm.cn.mapper;

import java.util.List;

import cm.cn.po.JsQuesion;

public interface QuestionMapper {
	//����������
	public int insertList(List<JsQuesion> list); 
	//��ѯ���е���Ŀ(����������)
	public List<JsQuesion> selectAllQuestion();
	/**
	 * �����ѯ������Ŀ
	 * @param type_id 1��ѡ2��ѡ3�ж�,�������û���д
	 * @param begin	�����
	 * @param total ���ȡ��Ŀ�����������û���д��
	 * @return
	 */
	public List<JsQuesion> selectRandomQuestion(int type_id,int begin,int total);
	//������Ŀ����ѯ���������Ŀ����
	public int selectCount(int type_id);
	//������ѯ������Ŀ
	public List<JsQuesion> selectTypeQuestion(int type_id);
}
