package cm.cn.mapper;

import java.util.List;

import cm.cn.po.CaseAndQuestion;

public interface CaseQuesMapper {
	public List<CaseAndQuestion> selectCaseAndQues(String[] array);
}
