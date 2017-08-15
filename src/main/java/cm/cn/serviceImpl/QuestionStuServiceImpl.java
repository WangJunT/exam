package cm.cn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.cn.mapper.JsQuestionStuMapper;
import cm.cn.po.JsQuestionStu;
import cm.cn.po.JsQuestionStuExample;
import cm.cn.service.QuestionStuService;
@Service
public class QuestionStuServiceImpl implements QuestionStuService {
	@Autowired
	JsQuestionStuMapper jsQuestionStuMapper;
	
	@Override
	public List<JsQuestionStu> selectIfExit(int id) {
		JsQuestionStuExample example = new JsQuestionStuExample();
		JsQuestionStuExample.Criteria criteria = example.createCriteria();
		criteria.andStuIdEqualTo(id);
		return jsQuestionStuMapper.selectByExample(example);
	}

	@Override
	public int insertRecord(JsQuestionStu jsQuestionStu) {
		return jsQuestionStuMapper.insertSelective(jsQuestionStu);
	}

	@Override
	public int updateRecord(JsQuestionStu jsQuestionStu) {
		return jsQuestionStuMapper.updateByPrimaryKeySelective(jsQuestionStu);
	}

}
