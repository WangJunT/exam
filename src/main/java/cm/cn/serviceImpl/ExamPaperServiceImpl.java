package cm.cn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.cn.mapper.ExampaperMapper;
import cm.cn.mapper.ExampaperStuMapper;
import cm.cn.mapper.JsExampaperMapper;
import cm.cn.po.JsExampaper;
import cm.cn.po.JsExampaperExample;

@Service
public class ExamPaperServiceImpl implements cm.cn.service.ExamPaperService {

	@Autowired
	JsExampaperMapper jsExampaperMapper;
	@Autowired
	ExampaperMapper exampaperMapper;
	@Autowired
	ExampaperStuMapper exampaperStuMapper;
	@Override
	public int addExamPaper(JsExampaper jsExampaper) {
		return jsExampaperMapper.insertSelective(jsExampaper);
	}
	@Override
	public List<JsExampaper> selectAll(String reserveFive,String reserveSix) {
		JsExampaperExample example = new JsExampaperExample();
		JsExampaperExample.Criteria criteria = example.createCriteria();
		if (!(reserveFive == null ||"".equals(reserveFive))) {
			criteria.andReserveFiveEqualTo(reserveFive);
		}
		if (!(reserveSix == null ||"".equals(reserveSix))) {
			criteria.andReserveSixEqualTo(reserveSix);
		}
		return jsExampaperMapper.selectByExample(example);
	}
	@Override
	public JsExampaper selectById(int id) {
		return jsExampaperMapper.selectByPrimaryKey(id);
	}
	@Override
	public int delExam(int[] intarray) {
		//先刪除外键关联
		exampaperStuMapper.delByExamIdArray(intarray);
		return exampaperMapper.delByIdArray(intarray);
	}

}
