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
import cm.cn.po.StuDoneQues;
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
	public List<JsQuesion> selectAllQuestion(String reserveFive,String reserveSix) {
		JsQuesionExample example = new JsQuesionExample();
		JsQuesionExample.Criteria criteria = example.createCriteria();
		if (!(reserveFive == null ||"".equals(reserveFive))) {
			criteria.andReserveFiveEqualTo(reserveFive);
		}
		if (!(reserveSix == null ||"".equals(reserveSix))) {
			criteria.andReserveSixEqualTo(reserveSix);
		}
		return jsquestionMapper.selectByExample(example);
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
	public int delQues(int id) {
		return jsquestionMapper.deleteByPrimaryKey(id);
	}
	@Override
	public List<StuDoneQues> selStuDeonQues() {
		return questionMapper.selStuDeonQues();
	}
	@Override
	public int delQuesBatch(String[] array) {
		return questionMapper.delQuesBatch(array);
	}
	@Override
	public int delQuesByLevel(String reserveSix) {
		JsQuesionExample example = new JsQuesionExample();
		JsQuesionExample.Criteria criteria = example.createCriteria();
		if (!(reserveSix == null ||"".equals(reserveSix))) {
			criteria.andReserveSixEqualTo(reserveSix);
		}
		return jsquestionMapper.deleteByExample(example);
	}
	@Override
	public int updateByid(JsQuesion jsQuesion) {
		// TODO Auto-generated method stub
		return jsquestionMapper.updateByPrimaryKeySelective(jsQuesion);
	}

}
