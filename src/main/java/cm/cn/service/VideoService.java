package cm.cn.service;

import java.util.List;

import cm.cn.po.JsVideo;

public interface VideoService {
	//�ϴ�����
	public int insertVideo(JsVideo jsVideo);
	//�鿴��������(��ʦ���㼶�鿴��ѧ��ֻ�ܲ鿴��Ӧ�㼶������)
	public List<JsVideo> allVideo(String reserveFive,String reserveSix);
	//���� id �õ���Ӧ������
	public JsVideo selById(int id);
	//���� id ɾ����Ӧ������
	public int delById(int id);
}
