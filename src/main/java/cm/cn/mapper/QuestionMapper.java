package cm.cn.mapper;

import java.util.List;

import cm.cn.po.JsQuesion;
import cm.cn.po.PageQuestion;
import cm.cn.po.RandomQuestion;
import cm.cn.po.StuDoneQues;

public interface QuestionMapper {
	//����������
	public int insertList(List<JsQuesion> list); 
	//��ѯ���е���Ŀ(����������)
	public List<JsQuesion> selectAllQuestion();
	//�������� id �����ѯ��selectJsQuestion
	public List<String> selectAnswer(String[] array);
	//�������� id ��ѯJsQuestion
	public List<JsQuesion> selectJsQuestion(String[] array);
	//��ҳ��ѯ
	public List<JsQuesion> selectJsQuestionlimit(PageQuestion pageQuestion);
	//�����ѯ��Ŀ
	public List<JsQuesion> selectRan(RandomQuestion randomQuestion);
	//ѧ������������Ϣ
	public List<StuDoneQues> selStuDeonQues();
	//���� ID ����ɾ����Ŀ
	public int delQuesBatch(String[] array);
}
