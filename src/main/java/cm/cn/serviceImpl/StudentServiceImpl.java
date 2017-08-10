package cm.cn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.cn.mapper.JsUserMapper;
import cm.cn.mapper.StudentMapper;
import cm.cn.po.JsUser;
import cm.cn.po.JsUserExample;
import cm.cn.po.JsUserExample.Criteria;
import cm.cn.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentMapper studentMapper;
	@Autowired
	JsUserMapper jsUserMapper;
	@Override
	public int insertStuList(List<JsUser> stu) {
		return studentMapper.insertStuList(stu);
	}
	@Override
	public int insertStu(JsUser stu) {
		return jsUserMapper.insertSelective(stu);
	}
	@Override
	public List<JsUser> selectStu(String phone) {
		JsUserExample jsUserExample = new JsUserExample();
		JsUserExample.Criteria criteria = jsUserExample.createCriteria();
		criteria.andPhoneEqualTo(phone);
		return jsUserMapper.selectByExample(jsUserExample);
	}
	@Override
	public int updateStu(JsUser jsUser) {
		JsUserExample example = new JsUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andPhoneEqualTo(jsUser.getPhone());
		jsUser.setChenkTime(System.currentTimeMillis());
		return jsUserMapper.updateByExample(jsUser, example);
	}
	@Override
	public int updateStuPass(JsUser jsUser) {
		JsUserExample example = new JsUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andPhoneEqualTo(jsUser.getPhone());
		return jsUserMapper.updateByExample(jsUser, example);
	}
}
