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
	public int updateStuPass(String pass,JsUser dqyh);
	//使用用户密码的方式登陆
	public List<JsUser> selectBypass(String username);
	//查询所有的学生（用于导出）
	public List<JsUser> selectAll(String reserveFive,String reserveSix);
	//删除学生
	public int delStu(int id);
	//更改学生信息(只可更改电话号码，姓名，身份证号)
	public int updateStuInfo(JsUser jsUser);
	//批量删除学生
	public int delStuBatch(int[] array);
}
