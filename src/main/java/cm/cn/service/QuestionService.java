package cm.cn.service;

import java.util.List;

import cm.cn.po.JsQuesion;
import cm.cn.po.PageQuestion;
import cm.cn.po.RandomQuestion;
import cm.cn.po.StuDoneQues;

public interface QuestionService {
	//����������Ŀ��������⣩
	public int insertList(List<JsQuesion> list);
	//��ʦ�鿴���е���Ŀ����ʦ�ɰ��㼶���鿴����ѧ����˳����ϰ
	public List<JsQuesion> selectAllQuestion(String reserveFive,String reserveSix);
	//����������ѯ��Ŀ
	public JsQuesion selectQuePrimary(int id);
	//�������� id �����ѯ��
	public List<String> selectAnswer(String[] array);
	//�������� id ��ѯJsQuestion
	public List<JsQuesion> selectJsQuestion(String[] array);
	//��ҳ��ѯ
	public List<JsQuesion> selectJsQuestionlimit(PageQuestion pageQuestion);
	//���ѡ��(��ʦ�����ʱѡ���Ӧ��λ)
	public List<JsQuesion> selectRan(RandomQuestion randomQuestion);
	//ɾ������
	public int delQues(int id);
	//ѧ������������Ϣ
	public List<StuDoneQues> selStuDeonQues();
	//�������ɾ��
	public int delQuesBatch(String[] array);
}
