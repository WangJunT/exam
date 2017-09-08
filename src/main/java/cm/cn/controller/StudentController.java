package cm.cn.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cm.cn.po.JsUser;
import cm.cn.service.StudentService;

@Controller
@RequestMapping("/stu")
public class StudentController {
	@Autowired
	StudentService studentService;
	@RequestMapping("/myself")
	@ResponseBody
	public JsUser myself(HttpServletRequest request){
		//获取Session  
        HttpSession session = request.getSession();  
        JsUser jsUser = (JsUser)session.getAttribute("user");
        return jsUser;
	}
	@RequestMapping(value="/change",method = RequestMethod.POST)
	@ResponseBody
	public Map<Integer, String> updatePass(@RequestBody JsUser jsUser,HttpServletRequest request){
		Map<Integer, String> map = new HashMap<>();
		JsUser dqyh = (JsUser) request.getSession().getAttribute("user");
		if (dqyh.getPhone().equals(jsUser.getPhone())) {
			if (studentService.updateStuPass(jsUser.getPassword(),dqyh)>0) {
				map.put(0, "更改密码成功");
			}else{
				map.put(1, "密码未更改");
			}
		}
		else{
			map.put(2,"电话号码有误");
		}
		return map ;
	}
//	@RequestMapping("/myself")
//	@ResponseBody
//	public 
	
}
