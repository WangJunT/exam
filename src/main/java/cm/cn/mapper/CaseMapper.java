package cm.cn.mapper;

import java.util.List;

public interface CaseMapper {
	public List<String> findByLevel(String reserveSix);
	public int delCaseByIdArray(String[] array);
	public int delCaseQuestionByIdArray(String[] array);
}
