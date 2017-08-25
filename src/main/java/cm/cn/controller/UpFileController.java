package cm.cn.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cm.cn.po.JsQuesion;
import cm.cn.po.JsUser;
import cm.cn.service.QuestionService;
import cm.cn.service.StudentService;
import cm.cn.service.UpCaseQues;
import cm.cn.util.QuesExcelUtil;
import cm.cn.util.StuExcelUtil;

@Controller
@RequestMapping("/admin")
public class UpFileController {
	@Autowired
	StudentService studentService;
	@Autowired
	QuestionService questionService;
	@Autowired
	UpCaseQues upCaseQues;
	//批量添加题目
		@RequestMapping("/addQuesFile")
		@ResponseBody
		public String addQuesFile(MultipartFile file){
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
			return filePath;
		}
		@RequestMapping("/addQuesBatch")
		@ResponseBody
		public Map<Integer, String> addQuesBatch(String filePath,String reserveFive,String reserveSix){
			Map<Integer, String> map = new HashMap<>();
			List<JsQuesion> list = QuesExcelUtil.excelToQues(filePath,reserveFive,reserveSix);
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
		//添加简答题
		@RequestMapping("/addCase")
		@ResponseBody
		public Map<Integer, String> addCase(MultipartFile file){
			Map<Integer, String> map = new HashMap<>();
			 //获取文件名  
		    String fileName = file.getOriginalFilename();  
		    //文件扩展名  
		    String newFileName = "case"+UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."));  
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
			upCaseQues.excelToJsCase(filePath);
			return map ;
		}
		//添加学生
		@RequestMapping("/addStuBatch")
		@ResponseBody
		public String addStuBatch(MultipartFile file){
//			Map<Integer, String> map = new HashMap<>();
			 //获取文件名  
		    String fileName = file.getOriginalFilename();  
		    //文件扩展名  
		    String newFileName = "stu"+UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."));  
		    // 存储文件的物理路径
	 	 	String video_path = "D:\\";
	 	 	String filePath = video_path + newFileName;
	 	 	// 新文件
	 		File newFile = new File(filePath);
	 		try {
				file.transferTo(newFile);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return filePath;
		}
		@RequestMapping("/addStuFile")
		@ResponseBody
		public Map<Integer, String> addStuFile(String filePath,String reserveFive,String reserveSix){
			Map<Integer, String> map = new HashMap<>();
			List<JsUser> list = StuExcelUtil.excelToStu(filePath,reserveFive,reserveSix);
			if (list.size()>0) {
				if (studentService.insertStuList(list)>0){
					map.put(0, "上传成功");
				}
				else{
					map.put(1, "添加失败，请参照模板上传");
				}
			}
			else{
				map.put(2, "文件未上传成功,请仔细检查文件格式");
			}
			return map;
		}
}
