package cm.cn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cm.cn.po.JsExampaperStu;
import cm.cn.po.JsUser;
import cm.cn.service.ExampaperStuService;

@Controller
@RequestMapping("/sexam")
public class ExamPaperStuController {
	@Autowired
	ExampaperStuService exampaperStuService;
	@RequestMapping("/sorup")
	@ResponseBody
	public Map<Integer , String> sorup(JsExampaperStu jsExampaperStu,HttpSession session){
		Map<Integer, String> map = new HashMap<>();
		JsUser jsUser = (JsUser) session.getAttribute("user");
		jsExampaperStu.setStuId(jsUser.getId());
		List<JsExampaperStu> list = exampaperStuService.selectIfExam(jsExampaperStu);
		if (list.size()>0) {
			Double score = jsExampaperStu.getScore();
			jsExampaperStu = list.get(0);
			jsExampaperStu.setScore(score);
			exampaperStuService.updateStuExam(jsExampaperStu);
			map.put(0, "试卷提交成功");
		}
		else{
			exampaperStuService.insertStuExam(jsExampaperStu);
			map.put(1, "试卷提交成功");
		}
		return map;
	}
}
