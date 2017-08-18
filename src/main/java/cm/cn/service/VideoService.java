package cm.cn.service;

import java.util.List;

import cm.cn.po.JsVideo;

public interface VideoService {
	//上传视屏
	public int insertVideo(JsVideo jsVideo);
	//查看所有视屏
	public List<JsVideo> allVideo();
}
