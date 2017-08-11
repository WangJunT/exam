package cm.cn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cm.cn.po.JsQuesion;
import cm.cn.po.PageQuestion;
import cm.cn.po.RandomQuestion;
import cm.cn.service.QuestionService;
import cm.cn.service.UpCaseQues;
import cm.cn.util.QuesExcelUtil;

@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	@Autowired
	UpCaseQues upCaseQues;
	@RequestMapping("/addCase")
	@ResponseBody
	public Map<Integer, String> addCase(){
		Map<Integer, String> map = new HashMap<>();
		String filePath = "C:\\Users\\dnd\\Documents\\WeChat Files\\wxid_5xxl7t4xw9ws22\\Files\\材料员实务.xls";
		upCaseQues.excelToJsCase(filePath);
		return map ;
	}
	@RequestMapping("/addQuesBatch")
	@ResponseBody
	public Map<Integer, String> addQuesBatch(){
		Map<Integer, String> map = new HashMap<>();
		String filePath = "C:\\Users\\dnd\\Documents\\WeChat Files\\wxid_5xxl7t4xw9ws22\\Files\\电工.xlsx";
		List<JsQuesion> list = QuesExcelUtil.excelToQues(filePath);
		if (list.size()>0) {
			if (questionService.insertList(list)>0){
				map.put(0, "上传成功");
			}
			else{
				map.put(1, "添加失败");
			}
		}
		else{
			map.put(2, "文件格式错误或数据有误");
		}
		return map;
	}
	@RequestMapping("/selectRandomQuestion")
	@ResponseBody
	public List<JsQuesion> selectRandomQuestion(int type_id,int total){
		List<JsQuesion> list = questionService.selectRandomQuestion(type_id,total);
		return list;
	}
	@RequestMapping("/selectLimit")
	@ResponseBody
	public List<JsQuesion> selectLimit(PageQuestion pageQuestion){
		List<JsQuesion> list= questionService.selectJsQuestionlimit(pageQuestion);
		return list;
	}
	@RequestMapping("/selectRan")
	@ResponseBody
	public List<JsQuesion> selectRan(RandomQuestion randomQuestion){
		List<JsQuesion> list= questionService.selectRan(randomQuestion);
		System.out.println(list.size());
		return list;
	}
}
