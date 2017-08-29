package cm.cn.service;

import java.util.List;


public interface CaseService {
	//根据层级查找简答题
	public List<String> findByLevel(String reserveSix);
	//根据 id 数组删除简答题
	public int delByIdArray(String[] array);
}
