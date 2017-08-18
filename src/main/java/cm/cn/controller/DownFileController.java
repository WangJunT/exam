package cm.cn.controller;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cm.cn.po.JsUser;
import cm.cn.service.StudentService;
import cm.cn.util.ListStuToExcel;

@Controller
public class DownFileController {
	@Autowired
	StudentService studentService;
	@RequestMapping("/down")
	@ResponseBody
	public Map<Integer, String> stuDown(HttpServletResponse res){
		Map<Integer, String> map = new HashMap<>();
		 List<JsUser> list = studentService.selectAll();
			if (list.size()>0) {
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				BufferedInputStream bis = null;
				BufferedOutputStream bos = null;
				try {
					ListStuToExcel.questionToExcel(list).write(os);
					String fileName = "学生信息表";
				      byte[] content = os.toByteArray();
				      InputStream is = new ByteArrayInputStream(content);
				      // 设置response参数，可以打开下载页面
				      res.reset();
				      res.setContentType("application/vnd.ms-excel;charset=utf-8");
				      res.setHeader("Content-Disposition", "attachment;filename="
				          + new String((fileName + ".xlsx").getBytes(), "utf-8"));
				      ServletOutputStream out = res.getOutputStream();
				      bis = new BufferedInputStream(is);
				        bos = new BufferedOutputStream(out);
				        byte[] buff = new byte[2048];
				        int bytesRead;
				        // Simple read/write loop.
				        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				          bos.write(buff, 0, bytesRead);
				        }
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						}
				      finally {
				        if (bis != null)
							try {
								bis.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				        if (bos != null)
							try {
								bos.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				      }
		}
		else{
			map.put(1,"导出失败");
		}
	     
		return map;
	}
}
