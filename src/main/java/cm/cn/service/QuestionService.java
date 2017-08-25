package cm.cn.service;

import java.util.List;

import cm.cn.po.JsQuesion;
import cm.cn.po.PageQuestion;
import cm.cn.po.RandomQuestion;

public interface QuestionService {
	//����������Ŀ��������⣩
	public int insertList(List<JsQuesion> list);
	//�鿴���е���Ŀ��������⣩
	public List<JsQuesion> selectAllQuestion();
	//����������ѯ��Ŀ
	public JsQuesion selectQuePrimary(int id);
	//�������� id �����ѯ��
	public List<String> selectAnswer(String[] array);
	//�������� id ��ѯJsQuestion
	public List<JsQuesion> selectJsQuestion(String[] array);
	//��ҳ��ѯ
	public List<JsQuesion> selectJsQuestionlimit(PageQuestion pageQuestion);
	//���ѡ��
	public List<JsQuesion> selectRan(RandomQuestion randomQuestion);
	//��ѯ��������Ծ�����
	public int selAllCount(JsQuesion jsQuesion);
}
