package cm.cn.service;

import java.util.List;

import cm.cn.po.JsVideo;

public interface VideoService {
	//�ϴ�����
	public int insertVideo(JsVideo jsVideo);
	//�鿴��������
	public List<JsVideo> allVideo();
	//���� id �õ���Ӧ������
	public JsVideo selById(int id);
}
