package cm.cn.service;

import java.util.List;

import cm.cn.po.JsUser;

public interface StudentService {
	//批量添加学生
	public int insertStuList(List<JsUser> stu);
	//单独添加
	public int insertStu(JsUser stu);
}
