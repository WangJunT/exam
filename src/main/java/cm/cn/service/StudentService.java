package cm.cn.service;

import java.util.List;

import cm.cn.po.JsUser;

public interface StudentService {
	//�������ѧ��
	public int insertStuList(List<JsUser> stu);
	//�������
	public int insertStu(JsUser stu);
}
