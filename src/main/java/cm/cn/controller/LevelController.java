package cm.cn.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cm.cn.po.JsLevel;
import cm.cn.service.CaseService;
import cm.cn.service.ExamPaperService;
import cm.cn.service.LevelService;
import cm.cn.service.QuestionService;
import cm.cn.service.StudentService;
import cm.cn.util.RandomAndSpiltUtil;

@Controller
@RequestMapping("/level")
public class LevelController {
	@Autowired
	LevelService levelService;
	@Autowired
	CaseService caseService;
	@Autowired
	ExamPaperService examPaperService;
	@Autowired
	QuestionService questionService;
	@Autowired
	StudentService studentService;
	@RequestMapping("/selOne")
	@ResponseBody
	public List<JsLevel> selOne() {
		return levelService.selOne();
	}

	@RequestMapping("/selTwo")
	@ResponseBody
	public List<JsLevel> selTwo(int id) {
		return levelService.selTwo(id);
	}

	// 删除管理类别的第二级
	@RequestMapping("/delTwo")
	@ResponseBody
	public Map<Integer, String> delTwo(int id) {
		Map<Integer, String> map = new HashMap<>();
		//不用获取题目 ID，可直接删除题目
		questionService.delQuesByLevel(String.valueOf(id));
		// 首先获取简答题 id
		List<String> listCase = caseService.findByLevel(String.valueOf(id));
		//删除简答题以及其子题目
		if (listCase.size()>0) {
			caseService.delByIdArray(RandomAndSpiltUtil.listtoStr(listCase));
		}
		//获取试卷 ID
		List<String> listExam = examPaperService.findByLevel(String.valueOf(id));
		//删除试卷、删除学生试卷
		if (listExam.size()>0) {
			examPaperService.delExam(RandomAndSpiltUtil.listtoStr(listExam));
		}
		//获取学生 id
		List<String> listStu = studentService.findStuIdByLevel(String.valueOf(id));
		if (listStu.size()>0){
			studentService.delStuBatch(RandomAndSpiltUtil.listtoStr(listStu));
		}
		//删除学生试卷关系，删除学生做题关系，删除学生
		if (levelService.delLevel(id) > 0) {
			map.put(0, "删除成功");
		} else {
			map.put(1, "删除失败");
		}
		return map;
	}

	// 前端需要传入上一层级 ID ，该层级名称，层级已在 实现层设为 2
	@RequestMapping("/addTwo")
	@ResponseBody
	public Map<Integer, String> addTwo(JsLevel level) {
		String name = null;
		try {
			name = new String(level.getName().getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		level.setName(name);
		Map<Integer, String> map = new HashMap<>();
		if (levelService.inLevel(level) > 0) {
			map.put(0, "添加成功");
		} else {
			map.put(1, "添加失败");
		}
		return map;
	}
}
