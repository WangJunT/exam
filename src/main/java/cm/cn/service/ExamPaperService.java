package cm.cn.service;

import java.util.List;

import cm.cn.po.JsExampaper;

public interface ExamPaperService {
	//������
	public int addExamPaper(JsExampaper jsExampaper);
	//�鿴�����Ծ�
	public List<JsExampaper> selectAll(String reserveFive,String reserveSix);
	//����(����ǰ��������Ŀ,��)
	public JsExampaper selectById(int id);
	//	ɾ���Ծ�
//	public int delExam(int[] intarray);
	//����ɾ���Ծ�
	public int delExam(int id);
}
