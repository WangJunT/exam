package cm.cn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.cn.mapper.ExampaperStuMapper;
import cm.cn.mapper.JsExampaperStuMapper;
import cm.cn.po.JsExampaperStu;
import cm.cn.po.JsExampaperStuExample;
import cm.cn.po.StuDoneExam;
import cm.cn.service.ExampaperStuService;

@Service
public class ExampaperStuServiceImpl implements ExampaperStuService {
	
	@Autowired
	JsExampaperStuMapper jsExampaperStuMapper;
	@Autowired
	ExampaperStuMapper exampaperStuMapper;
	@Override
	public List<JsExampaperStu> selectIfExam(JsExampaperStu examStu) {
		JsExampaperStuExample jStuExample = new JsExampaperStuExample();
		JsExampaperStuExample.Criteria criteria = jStuExample.createCriteria();
		criteria.andExampaperIdEqualTo(examStu.getExampaperId());
		criteria.andStuIdEqualTo(examStu.getStuId());
		return jsExampaperStuMapper.selectByExample(jStuExample);
	}

	@Override
	public int insertStuExam(JsExampaperStu examStu) {
		return jsExampaperStuMapper.insertSelective(examStu);
	}

	@Override
	public int updateStuExam(JsExampaperStu examStu) {
		return jsExampaperStuMapper.updateByPrimaryKeySelective(examStu);
	}

//	@Override
//	public int delStuExam(int[] arrays) {
//		return exampaperStuMapper.delByExamIdArray(arrays);
//	}

	@Override
	public List<StuDoneExam> seleDone(int stuid) {
		return exampaperStuMapper.selDone(stuid);
	}

	@Override
	public List<StuDoneExam> selExamStu() {
		// TODO Auto-generated method stub
		return exampaperStuMapper.selStuDone();
	}

	@Override
	public int delStuDoneExam(int id) {
		JsExampaperStuExample example = new JsExampaperStuExample();
		JsExampaperStuExample.Criteria criteria = example.createCriteria();
		criteria.andExampaperIdEqualTo(id);
		return jsExampaperStuMapper.deleteByExample(example);
	}

}
