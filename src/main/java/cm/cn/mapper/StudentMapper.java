package cm.cn.mapper;

import java.util.List;

import cm.cn.po.JsUser;

public interface StudentMapper {
	//批量添加学生
	public int insertStuList(List<JsUser> stu);
	//批量删除学生
	public int delStuBatch(String[] array);
	//根据特定字段查询学生 Id 
	public List<String> findStuIdByLevel(String reserveSix);
}
