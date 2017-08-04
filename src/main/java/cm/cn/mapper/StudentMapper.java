package cm.cn.mapper;

import java.util.List;

import cm.cn.po.JsUser;

public interface StudentMapper {
	//批量添加學生
	public int insertStuList(List<JsUser> stu);
}
