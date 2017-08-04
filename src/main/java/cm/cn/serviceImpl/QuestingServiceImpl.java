package cm.cn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.cn.mapper.JsQuesionMapper;
import cm.cn.mapper.QuestionMapper;
import cm.cn.po.JsQuesion;
import cm.cn.po.JsQuesionExample;
import cm.cn.service.QuestionService;
import cm.cn.util.RandomAndSpiltUtil;

@Service
public class QuestingServiceImpl implements QuestionService {

	@Autowired
	QuestionMapper questionMapper;
	@Autowired
	JsQuesionMapper jsquestionMapper;
	@Override
	public int insertList(List<JsQuesion> list) {
		return questionMapper.insertList(list);
	}
	@Override
	public List<JsQuesion> selectAllQuestion() {
		return questionMapper.selectAllQuestion();
	}
	@Override
	public List<JsQuesion> selectRandomQuestion(int type_id, int total) {
		int begin = RandomAndSpiltUtil.RandomInt();
		return questionMapper.selectRandomQuestion(type_id, begin, total);
	}
	@Override
	public int selectCount(int type_id) {
		return questionMapper.selectCount(type_id);
	}
	@Override
	public List<JsQuesion> selectTypeQuestion(int type_id) {
		return questionMapper.selectTypeQuestion(type_id);
	}
	@Override
	public JsQuesion selectQuePrimary(int id) {
		return jsquestionMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<String> selectAnswer(String[] array) {
		return questionMapper.selectAnswer(array);
	}
	@Override
	public List<JsQuesion> selectQues(int ques_type, int difficult_type) {
		JsQuesionExample jsQuesionExample = new JsQuesionExample();
		JsQuesionExample.Criteria criteria = jsQuesionExample.createCriteria();
		if (ques_type!=0){
			criteria.andTypeIdEqualTo(ques_type);
		}
		if (difficult_type!=0){
			criteria.andDifficultTypeEqualTo(difficult_type);
		}
		return jsquestionMapper.selectByExample(jsQuesionExample);
	}

}
