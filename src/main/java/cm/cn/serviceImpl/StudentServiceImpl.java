package cm.cn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.cn.mapper.StudentMapper;
import cm.cn.po.JsUser;
import cm.cn.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentMapper studentMapper;
	@Override
	public int insertStuList(List<JsUser> stu) {
		return studentMapper.insertStuList(stu);
	}
	@Override
	public int insertStu(JsUser stu) {
		// TODO Auto-generated method stub
		return 0;
	}

}
