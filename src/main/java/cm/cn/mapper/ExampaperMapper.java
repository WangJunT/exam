package cm.cn.mapper;

import java.util.List;

public interface ExampaperMapper {
	//根据 id 数组删除试卷
	public int delByIdArray(String[] intarray);
	//根据 层级查询试卷 id 数组
	public List<String> findByLevel(String reserveSix);
}
