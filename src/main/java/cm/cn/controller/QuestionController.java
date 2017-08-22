package cm.cn.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cm.cn.po.JsQuesion;
import cm.cn.po.JsQuestionStu;
import cm.cn.po.JsUser;
import cm.cn.po.PageQuestion;
import cm.cn.po.RandomQuestion;
import cm.cn.service.QuestionService;
import cm.cn.service.QuestionStuService;
import cm.cn.service.UpCaseQues;
import cm.cn.util.QuesExcelUtil;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionStuService questionStuService;
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
	//批量添加题目
	@RequestMapping("/addQuesBatch")
	@ResponseBody
	public Map<Integer, String> addQuesBatch(MultipartFile file){
		Map<Integer, String> map = new HashMap<>();
		 //获取文件名  
	    String fileName = file.getOriginalFilename();  
	    //文件扩展名  
	    String newFileName = "ques"+UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."));  
	    // 存储文件的物理路径
	 	String video_path = "D:\\";
	 	String filePath = video_path + newFileName;
	 	// 新文件,存到磁盘
		File newFile = new File(filePath);
		try {
			file.transferTo(newFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
//	@RequestMapping("/orderPractice")
//	@ResponseBody
//	public Map<Integer, Object> orderPractice(PageQuestion pageQuestion,HttpSession session){
//		Map<Integer, Object> map = new HashMap<>();
//		JsUser jsUser = (JsUser) session.getAttribute("user");
//		List<JsQuestionStu> list1 = null;
//		JsQuestionStu jsQuestionStu = null;
//		int start = pageQuestion.getStart();
//		list1 = questionStuService.selectIfExit(jsUser.getId());
//		if (list1.size()>0) {
//			jsQuestionStu = list1.get(0);
//			start = jsQuestionStu.getTotal();
//			pageQuestion.setStart(start);
//		}
//		List<JsQuesion> list= questionService.selectJsQuestionlimit(pageQuestion);
//		map.put(0, start);
//		map.put(1, list);
//		return map;
//	}
	//进入顺序练习
	@RequestMapping("/orderPractice")
	@ResponseBody
	public Map<Integer, Object> orderPractice(HttpSession session){
		Map<Integer, Object> map = new HashMap<>();
		PageQuestion pageQuestion = new PageQuestion();
		JsUser jsUser = (JsUser) session.getAttribute("user");
		List<JsQuestionStu> list1 = null;
		JsQuestionStu jsQuestionStu = new JsQuestionStu();
		int start = 0;
		list1 = questionStuService.selectIfExit(jsUser.getId());
		if (list1.size()>0) {
			jsQuestionStu = list1.get(0);
			start = jsQuestionStu.getTotal();
		}
		pageQuestion.setStart(start);
		pageQuestion.setSize(10);;
		List<JsQuesion> list= questionService.selectJsQuestionlimit(pageQuestion);
		map.put(0, start);
		map.put(1, list);
		return map;
	}
	//分页显示
	@RequestMapping("/selectLimit")
	@ResponseBody
	public List<JsQuesion> selectLimit(PageQuestion pageQuestion,HttpSession session){
//		JsUser jsUser = (JsUser) session.getAttribute("user");
//		List<JsQuestionStu> list1 = null;
//		JsQuestionStu jsQuestionStu = null;
//		list1 = questionStuService.selectIfExit(jsUser.getId());
//		if (list1.size()>0) {
//			jsQuestionStu = list1.get(0);
//			pageQuestion.setStart(jsQuestionStu.getTotal());
//		}
		List<JsQuesion> list= questionService.selectJsQuestionlimit(pageQuestion);
		return list;
	}
	//退出顺序练习
	@RequestMapping("/quitPractice")
	@ResponseBody
	public Map<Integer, String> quitPractice(int start,HttpSession session){
		Map<Integer, String> map = new HashMap<>();
		JsUser jsUser = (JsUser) session.getAttribute("user");
		List<JsQuestionStu> list1 = null;
		JsQuestionStu jsQuestionStu = new JsQuestionStu();
		list1 = questionStuService.selectIfExit(jsUser.getId());
		if (list1.size()>0) {
			jsQuestionStu = list1.get(0);
			if (start>jsQuestionStu.getTotal()) {
				jsQuestionStu.setTotal(start);
				questionStuService.updateRecord(jsQuestionStu);
			}
			else
				start = jsQuestionStu.getTotal();
		}else{
			jsQuestionStu.setStuId(jsUser.getId());
			jsQuestionStu.setTotal(start);
			questionStuService.insertRecord(jsQuestionStu);
		}
		map.put(0, "你一共做了"+start+"题");
		return map;
	}
	@RequestMapping("/selectRan")
	@ResponseBody
	public List<JsQuesion> selectRan(RandomQuestion randomQuestion){
		List<JsQuesion> list= questionService.selectRan(randomQuestion);
		System.out.println(list.size());
		return list;
	}
}
