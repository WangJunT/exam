package cm.cn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.cn.mapper.QuestionMapper;
import cm.cn.po.JsQuesion;
import cm.cn.service.QuestionService;

@Service
public class QuestingServiceImpl implements QuestionService {

	@Autowired
	QuestionMapper questionMapper;
	@Override
	public int insertList(List<JsQuesion> list) {
		return questionMapper.insertList(list);
	}
	@Override
	public List<JsQuesion> selectAllQuestion() {
		return questionMapper.selectAllQuestion();
	}
	@Override
	public List<JsQuesion> selectRandomQuestion(int type_id, int begin, int total) {
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

}
