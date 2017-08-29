package cm.cn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.cn.mapper.CaseMapper;
import cm.cn.service.CaseService;
@Service
public class CaseServiceImpl implements CaseService {
	@Autowired
	CaseMapper caseMapper;

	@Override
	public int delByIdArray(String[] array) {
		//先删除简答题子题目
		caseMapper.delCaseQuestionByIdArray(array);
		return caseMapper.delCaseByIdArray(array);
	}

	@Override
	public List<String> findByLevel(String reserveSix) {
		// TODO Auto-generated method stub
		return caseMapper.findByLevel(reserveSix);
	}


}
