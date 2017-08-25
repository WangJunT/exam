package cm.cn.service;

import java.util.List;

import cm.cn.po.JsLevel;

public interface LevelService {
	//增加二级单位
	public int inLevel(JsLevel level);
	//删除二级单位
	public int delLevel(int id);
	//查看某一级单位下的二级单位
	public List<JsLevel> selTwo(int newlevel);
	//查看所有的一级单位
	public List<JsLevel> selOne();
}
