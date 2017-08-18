package cm.cn.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cm.cn.po.JsVideo;
import cm.cn.service.VideoService;

@Controller
public class VideoController {
	@Autowired
	VideoService videoService;
	@RequestMapping("/upVideo")
	public ModelAndView upVideo(MultipartFile file) throws IllegalStateException, IOException{
		 //获取文件名  
	    String fileName = file.getOriginalFilename();  
	    //文件扩展名  
	    String newFileName = UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."));  
	    
	    // 存储视屏的物理路径
	 	String video_path = "D:\\FFOutput\\";
	 	// 新视屏
		File newFile = new File(video_path + newFileName);
		file.transferTo(newFile);
	    ModelAndView modelAndView = new ModelAndView();
		JsVideo video = new JsVideo();
		video.setName(newFileName);
		video.setUrl(video_path+newFileName);
//		videoService.insertVideo(video);
		modelAndView.setViewName("testss/index");
		modelAndView.addObject("url",video.getUrl());
		return modelAndView;
	}
	@RequestMapping("/s")
	public String s(){
		return "testss/index";
	}
}
