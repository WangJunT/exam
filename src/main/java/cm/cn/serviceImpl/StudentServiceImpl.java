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
import cm.cn.util.Base64;

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
	public int updateStuPass(String pass,JsUser dqyh) {
		String password = Base64.encode(("zjedu"+pass+"cn").getBytes());
		JsUserExample example = new JsUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andPhoneEqualTo(dqyh.getPhone());
		dqyh.setPassword(password);
		return jsUserMapper.updateByExample(dqyh, example);
	}
	@Override
	public List<JsUser> selectBypass(String username) {
		JsUserExample example = new JsUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		return jsUserMapper.selectByExample(example);
	}
	@Override
	public List<JsUser> selectAll(String reserveFive,String reserveSix) {
		JsUserExample example = new JsUserExample();
		JsUserExample.Criteria criteria = example.createCriteria();
		if (!(reserveFive == null ||"".equals(reserveFive))) {
			criteria.andReserveFiveEqualTo(reserveFive);
		}
		if (!(reserveSix == null ||"".equals(reserveSix))) {
			criteria.andReserveSixEqualTo(reserveSix);
		}
		return jsUserMapper.selectByExample(example);
	}
}
