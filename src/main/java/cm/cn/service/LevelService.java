package cm.cn.service;

import java.util.List;

import cm.cn.po.JsLevel;

public interface LevelService {
	//���Ӷ�����λ
	public int inLevel(JsLevel level);
	//ɾ��������λ
	public int delLevel(int id);
	//�鿴ĳһ����λ�µĶ�����λ
	public List<JsLevel> selTwo(int newlevel);
	//�鿴���е�һ����λ
	public List<JsLevel> selOne();
}
