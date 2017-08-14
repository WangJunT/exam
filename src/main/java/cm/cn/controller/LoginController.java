package cm.cn.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cm.cn.po.JsUser;
import cm.cn.service.StudentService;
import cm.cn.util.Base64;
import cm.cn.util.GetCheckCode;

@Controller
@RequestMapping("/index")
public class LoginController {
	@Autowired
	StudentService studentService;
	@RequestMapping(value="/beforeLogin",method=RequestMethod.GET)
	@ResponseBody
	public Map<Integer, String> beforelogin(String phone){
		Map<Integer, String> map = new HashMap<>();
		List<JsUser> list = studentService.selectStu(phone);
		if(list.size()>0){
			JsUser jsUser = list.get(0);
			String check_code = String.valueOf((int)((Math.random()*9+1)*100000));
			if(GetCheckCode.getCode(phone,check_code)){
				jsUser.setCheckCode(check_code);
				jsUser.setChenkTime(System.currentTimeMillis());
				if(studentService.updateStu(jsUser)>0){
					map.put(0, "验证码发送成功");
				}
				else{
					map.put(1, "验证码发送发生错误");
				}
			}
			else{
				map.put(1, "验证码发送发生错误");
			}
			
		}
		else{
			map.put(2, "号码不存在");
		}
		return map;
	}
	@RequestMapping(value="/doLogin",method=RequestMethod.GET)
	@ResponseBody
	public Map<Integer, String> dologin(String phone,String chenk_code){
		Map<Integer, String> map = new HashMap<>();
		List<JsUser> list = studentService.selectStu(phone);
		if(list.size()>0){
			JsUser jsUser = list.get(0);
			long nowTime = System.currentTimeMillis();
			long cha = (nowTime-jsUser.getChenkTime())/1000;
			if(jsUser.getCheckCode().equals(chenk_code)){
				if(cha<=300)
					map.put(0, "登陆成功");
				else {
					map.put(1, "验证码超时");
				}
			}
			else
				map.put(2, "验证码错误");
		}else {
			map.put(3, "号码不存在");
		}
		return map;
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	@ResponseBody
	public Map<Integer, String> login(String username,String pass){
		Map<Integer, String> map = new HashMap<>();
		String str =null;
		try {
			str=new String(username.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<JsUser> list = studentService.selectBypass(str);
		if (list.size()>0) {
			JsUser jsUser = list.get(0);
			String password = Base64.encode(("zjedu"+pass+"cn").getBytes());
			if (password.equals(jsUser.getPassword())) {
				map.put(0, "登陆成功");
			}
			else{
				map.put(1, "密码错误");
			}
		}
		else {
			map.put(2, "该用户不存在");
		}
		return map ;
	}
}
