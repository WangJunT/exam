package cm.cn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cm.cn.po.JsExampaperStu;
import cm.cn.po.JsUser;
import cm.cn.service.ExampaperStuService;

@Controller
@RequestMapping("/sexam")
public class ExamPaperStuController {
	@Autowired
	ExampaperStuService exampaperStuService;
	@RequestMapping("sorup")
	public Map<Integer , String> sorup(JsExampaperStu jsExampaperStu,HttpSession session){
		Map<Integer, String> map = new HashMap<>();
		JsUser jsUser = (JsUser) session.getAttribute("user");
		jsExampaperStu.setStuId(jsUser.getId());
		List<JsExampaperStu> list = exampaperStuService.selectIfExam(jsExampaperStu);
		if (list.size()>0) {
			exampaperStuService.updateStuExam(jsExampaperStu);
		}
		else{
			exampaperStuService.insertStuExam(jsExampaperStu);
		}
		return map;
	}
}
