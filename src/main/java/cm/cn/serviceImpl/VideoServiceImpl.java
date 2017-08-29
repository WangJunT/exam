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
	public JsVideo selById(int id) {
		// TODO Auto-generated method stub
		return jsVideoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<JsVideo> allVideo(String reserveFive, String reserveSix) {
		JsVideoExample example = new JsVideoExample();
		JsVideoExample.Criteria criteria = example.createCriteria();
		if (!(reserveFive == null ||"".equals(reserveFive))) {
			criteria.andReserveFiveEqualTo(reserveFive);
		}
		if (!(reserveSix == null ||"".equals(reserveSix))) {
			criteria.andReserveSixEqualTo(reserveSix);
		}
		return jsVideoMapper.selectByExample(example);
	}
	@Override
	public int delById(int id) {
		// TODO Auto-generated method stub
		return jsVideoMapper.deleteByPrimaryKey(id);
	}
	@Override
	public int delVideo(String reserveFive, String reserveSix) {
		JsVideoExample example = new JsVideoExample();
		JsVideoExample.Criteria criteria = example.createCriteria();
		if (!(reserveFive == null ||"".equals(reserveFive))) {
			criteria.andReserveFiveEqualTo(reserveFive);
		}
		if (!(reserveSix == null ||"".equals(reserveSix))) {
			criteria.andReserveSixEqualTo(reserveSix);
		}
		return jsVideoMapper.deleteByExample(example);
	}

}
