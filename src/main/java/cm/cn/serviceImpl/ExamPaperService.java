package cm.cn.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.cn.mapper.JsExampaperMapper;
import cm.cn.po.JsExampaper;

@Service
public class ExamPaperService implements cm.cn.service.ExamPaperService {

	@Autowired
	JsExampaperMapper jsExampaperMapper;
	@Override
	public int addExamPaper(JsExampaper jsExampaper) {
		// TODO Auto-generated method stub
		return jsExampaperMapper.insertSelective(jsExampaper);
	}

}
