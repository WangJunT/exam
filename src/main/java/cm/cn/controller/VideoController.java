package cm.cn.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cm.cn.po.JsVideo;
import cm.cn.service.VideoService;

@Controller
@RequestMapping("/video")
public class VideoController {
	@Autowired
	VideoService videoService;
	@RequestMapping("/watchVideo")
	@ResponseBody
	public JsVideo watchVideo(int id){
		return videoService.selById(id);
	}
	@RequestMapping("/allVideo")
	@ResponseBody
	public List<JsVideo> allVideo(){
		return videoService.allVideo();
	}
	@RequestMapping("/admin/addVideo")
	@ResponseBody
	public Map<Integer, String> addVideo(@RequestBody JsVideo jsVideo ){
		Map<Integer, String> map = new HashMap<>();
		if (videoService.insertVideo(jsVideo)>0) {
			map.put(1, "视频上传成功");
		}
		else {
			map.put(2, "上传出错");
		}
		return map ;
	}
	//获取上传图片，视屏路径
	@RequestMapping("/admin/upVideoAndPic")
	@ResponseBody
	public List<String> upVideoAndPic(@RequestParam MultipartFile[] file){
		List<String> list = new ArrayList<>();
		 //获取文件名  
	    String videoFileName = file[0].getOriginalFilename(); 
	    String picName = file[1].getOriginalFilename();
	    //文件扩展名  
	    String newvideoFileName = "video"+UUID.randomUUID()+videoFileName.substring(videoFileName.lastIndexOf("."));  
	    String newPicName = "pic"+UUID.randomUUID()+picName.substring(picName.lastIndexOf("."));
	 // 存储视屏的物理路径
	 	 	String video_path = "D:\\";
	 	 	String pic_path = "D:\\";
	 	// 新视屏
			File videoFile = new File(video_path + newvideoFileName);
			File picFile = new File(pic_path+newPicName);
			list.add(videoFile.getAbsolutePath());
			list.add(picFile.getAbsolutePath());
			list.add(newvideoFileName);
			list.add(newPicName);
			try {
				file[0].transferTo(videoFile);
				file[1].transferTo(picFile);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;
	}
}
