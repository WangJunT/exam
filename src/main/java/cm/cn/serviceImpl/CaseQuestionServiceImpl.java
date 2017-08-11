package cm.cn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.cn.mapper.CaseQuesMapper;
import cm.cn.mapper.JsCaseMapper;
import cm.cn.mapper.JsCasequestionMapper;
import cm.cn.po.CaseAndQuestion;
import cm.cn.po.JsCase;
import cm.cn.po.JsCaseExample;
import cm.cn.po.JsCasequestion;
import cm.cn.po.JsCasequestionExample;
import cm.cn.service.CaseQuestionService;

@Service
public class CaseQuestionServiceImpl implements CaseQuestionService {
	@Autowired
	JsCaseMapper jsCaseMapper;
	@Autowired
	JsCasequestionMapper jsCasequestionMapper;
	@Autowired
	CaseQuesMapper caseQuesMapper;
	@Override
	public int insertCase(JsCase jsCase) {
		return jsCaseMapper.insertSelective(jsCase);
	}
	@Override
	public int insertZiQues(JsCasequestion jsCasequestion) {
		return jsCasequestionMapper.insertSelective(jsCasequestion);
	}
	@Override
	public List<JsCase> selectAll() {
		// TODO Auto-generated method stub
		JsCaseExample example = new JsCaseExample();
//		JsCaseExample.Criteria criteria = example.createCriteria();
		return jsCaseMapper.selectByExample(example);
	}
	@Override
	public CaseAndQuestion selectCase(int id) {
		CaseAndQuestion caseAndQuestion = new CaseAndQuestion();
		JsCase jsCase = jsCaseMapper.selectByPrimaryKey(id);
		JsCasequestionExample example = new JsCasequestionExample();
		JsCasequestionExample.Criteria criteria = example.createCriteria();
		criteria.andCaseIdEqualTo(id);
		List<JsCasequestion> list = jsCasequestionMapper.selectByExample(example);
		caseAndQuestion.setJsCase(jsCase);
		caseAndQuestion.setList(list);
		return caseAndQuestion;
	}
	@Override
	public List<CaseAndQuestion> selectCaseAndQues(String[] array) {
		// TODO Auto-generated method stub
		return caseQuesMapper.selectCaseAndQues(array);
	}
}
