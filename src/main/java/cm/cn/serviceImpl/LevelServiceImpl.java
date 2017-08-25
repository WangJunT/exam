package cm.cn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.cn.mapper.JsLevelMapper;
import cm.cn.po.JsLevel;
import cm.cn.po.JsLevelExample;
import cm.cn.service.LevelService;
@Service
public class LevelServiceImpl implements LevelService {
	@Autowired
	private JsLevelMapper jsLevelMapper;
	//层级直接设为2
	@Override
	public int inLevel(JsLevel level) {
		level.setLevel(2);
		return jsLevelMapper.insertSelective(level);
	}

	@Override
	public int delLevel(int id) {
		return jsLevelMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<JsLevel> selTwo(int newlevel) {
		JsLevelExample example = new JsLevelExample();
		JsLevelExample.Criteria criteria = example.createCriteria();
		criteria.andUplevelEqualTo(newlevel);
		return jsLevelMapper.selectByExample(example);
	}

	@Override
	public List<JsLevel> selOne() {
		JsLevelExample example = new JsLevelExample();
		JsLevelExample.Criteria criteria = example.createCriteria();
		criteria.andLevelEqualTo(1);
		return jsLevelMapper.selectByExample(example);
	}

}
