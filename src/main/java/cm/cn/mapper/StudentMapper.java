package cm.cn.mapper;

import java.util.List;

import cm.cn.po.JsUser;

public interface StudentMapper {
	//�������ѧ��
	public int insertStuList(List<JsUser> stu);
	//����ɾ��ѧ��
	public int delStuBatch(String[] array);
	//�����ض��ֶβ�ѯѧ�� Id 
	public List<String> findStuIdByLevel(String reserveSix);
}
