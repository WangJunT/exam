package cm.cn.service;

import java.util.List;

import cm.cn.po.JsUser;

public interface StudentService {
	//�������ѧ��
	public int insertStuList(List<JsUser> stu);
	//�������
	public int insertStu(JsUser stu);
	//���ݵ绰�����ѯ
	public List<JsUser> selectStu(String phone);
	//����ѧ����Ϣ(���ݵ绰���������֤�룬��¼ʱ��)
	public int updateStu(JsUser jsUser);
	//���ݵ绰�����������
	public int updateStuPass(JsUser jsUser);
	//ʹ���û�����ķ�ʽ��½
	public List<JsUser> selectBypass(String username);
}
