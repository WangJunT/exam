package cm.cn.service;

import java.util.List;

import cm.cn.po.JsCase;
import cm.cn.po.JsCasequestion;

public interface CaseQuestionService {
	//��������
	public int insertCase(JsCase jsCase);
	//�������������Ŀ
	public int insertZiQues(JsCasequestion jsCasequestion);
	//������ʾ���м���⣨ֻ������ɣ�
	public List<JsCase> selectAll();
}
