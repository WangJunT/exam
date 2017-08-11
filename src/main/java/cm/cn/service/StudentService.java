package cm.cn.service;

import java.util.List;

import cm.cn.po.JsUser;

public interface StudentService {
	//批量添加学生
	public int insertStuList(List<JsUser> stu);
	//单独添加
	public int insertStu(JsUser stu);
	//根据电话号码查询
	public List<JsUser> selectStu(String phone);
	//更改学生信息(根据电话号码更改验证码，登录时间)
	public int updateStu(JsUser jsUser);
	//根据电话号码更改密码
	public int updateStuPass(JsUser jsUser);
	//使用用户密码的方式登陆
	public List<JsUser> selectBypass(String username);
}
