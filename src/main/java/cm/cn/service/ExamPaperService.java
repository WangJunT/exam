package cm.cn.service;

import java.util.List;

import cm.cn.po.JsExampaper;

public interface ExamPaperService {
	//������
	public int addExamPaper(JsExampaper jsExampaper);
	//�鿴�����Ծ�
	public List<JsExampaper> selectAll();
	//����(����ǰ��������Ŀ,��)
	public JsExampaper selectById(int id);
}
