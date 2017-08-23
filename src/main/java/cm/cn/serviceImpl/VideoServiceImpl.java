package cm.cn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.cn.mapper.JsVideoMapper;
import cm.cn.po.JsVideo;
import cm.cn.po.JsVideoExample;
import cm.cn.service.VideoService;
@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	JsVideoMapper jsVideoMapper;
	@Override
	public int insertVideo(JsVideo video) {
		// TODO Auto-generated method stub
		return jsVideoMapper.insertSelective(video);
	}

	@Override
	public List<JsVideo> allVideo() {
		JsVideoExample example = new JsVideoExample();
		return jsVideoMapper.selectByExample(example);
	}

	@Override
	public JsVideo selById(int id) {
		// TODO Auto-generated method stub
		return jsVideoMapper.selectByPrimaryKey(id);
	}

}