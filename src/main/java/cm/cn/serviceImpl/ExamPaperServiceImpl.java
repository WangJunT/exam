package cm.cn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.cn.mapper.JsExampaperMapper;
import cm.cn.po.JsExampaper;
import cm.cn.po.JsExampaperExample;
import cm.cn.po.JsExampaperExample.Criteria;

@Service
public class ExamPaperServiceImpl implements cm.cn.service.ExamPaperService {

	@Autowired
	JsExampaperMapper jsExampaperMapper;
	@Override
	public int addExamPaper(JsExampaper jsExampaper) {
		// TODO Auto-generated method stub
		return jsExampaperMapper.insertSelective(jsExampaper);
	}
	@Override
	public List<JsExampaper> selectAll() {
		// TODO Auto-generated method stub
		JsExampaperExample example = new JsExampaperExample();
		Criteria criteria = example.createCriteria();
		return jsExampaperMapper.selectByExample(example);
	}
	@Override
	public JsExampaper selectById(int id) {
		// TODO Auto-generated method stub
		return jsExampaperMapper.selectByPrimaryKey(id);
	}

}
