package cm.cn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.cn.mapper.JsQuesionMapper;
import cm.cn.mapper.QuestionMapper;
import cm.cn.po.JsQuesion;
import cm.cn.po.JsQuesionExample;
import cm.cn.po.PageQuestion;
import cm.cn.po.RandomQuestion;
import cm.cn.service.QuestionService;

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
	public JsQuesion selectQuePrimary(int id) {
		return jsquestionMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<String> selectAnswer(String[] array) {
		return questionMapper.selectAnswer(array);
	}
	@Override
	public List<JsQuesion> selectJsQuestion(String[] array) {
		return questionMapper.selectJsQuestion(array);
	}
	@Override
	public List<JsQuesion> selectJsQuestionlimit(PageQuestion pageQuestion) {
		return questionMapper.selectJsQuestionlimit(pageQuestion);
	}
	@Override
	public List<JsQuesion> selectRan(RandomQuestion randomQuestion) {
		return questionMapper.selectRan(randomQuestion);
	}
	@Override
	public int selAllCount(JsQuesion jsQuesion) {
		JsQuesionExample jsQuesionExample = new JsQuesionExample();
		JsQuesionExample.Criteria criteria = jsQuesionExample.createCriteria();
		if (jsQuesion.getTypeId()!=0) {
			criteria.andTypeIdEqualTo(jsQuesion.getTypeId());
		}
		if (jsQuesion.getDifficultType()!=0) {
			criteria.andDifficultTypeEqualTo(jsQuesion.getDifficultType());
		}
		if (jsQuesion.getKnowType()!=null) {
			criteria.andKnowTypeEqualTo(jsQuesion.getKnowType());
		}
		if (jsQuesion.getExamType()!=null) {
			criteria.andExamTypeEqualTo(jsQuesion.getExamType());
		}
		if (jsQuesion.getLeibieType()!=null) {
			criteria.andLeibieTypeEqualTo(jsQuesion.getLeibieType());
		}
		return jsquestionMapper.countByExample(jsQuesionExample);
	}

}
