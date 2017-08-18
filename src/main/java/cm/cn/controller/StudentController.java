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

import cm.cn.po.JsUser;
import cm.cn.service.StudentService;
import cm.cn.util.ListStuToExcel;
import cm.cn.util.StuExcelUtil;

@Controller
@RequestMapping("/stu")
public class StudentController {
	@Autowired
	StudentService studentService;
	@RequestMapping("/addStuBatch")
	@ResponseBody
	public Map<Integer, String> addStuBatch(MultipartFile file){
		Map<Integer, String> map = new HashMap<>();
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
		List<JsUser> list = StuExcelUtil.excelToStu(filePath);
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
	@RequestMapping("/change")
	@ResponseBody
	public Map<Integer, String> updatePass(JsUser jsUser){
		Map<Integer, String> map = new HashMap<>();
		if (studentService.updateStuPass(jsUser)>0) {
			map.put(0, "更改密码成功");
		}
		else{
			map.put(1,"电话号码有误");
		}
		return map ;
	}
	@RequestMapping("/exportStu")
	@ResponseBody
	public Map<Integer, String> exportStu(JsUser jsUser){
		Map<Integer, String> map = new HashMap<>();
		List<JsUser> list = studentService.selectAll();
		if (list.size()>0) {
			ListStuToExcel.questionToExcel(list);
			map.put(0, "导出成功");
		}
		else{
			map.put(1,"未导出");
		}
		return map ;
	}
	
}
