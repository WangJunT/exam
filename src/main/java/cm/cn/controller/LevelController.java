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
import cm.cn.service.LevelService;

@Controller
@RequestMapping("/level")
public class LevelController {
	@Autowired
	LevelService levelService;
	@RequestMapping("/selOne")
	@ResponseBody
	public List<JsLevel> selOne(){
		return levelService.selOne();
	}
	@RequestMapping("/selTwo")
	@ResponseBody
	public List<JsLevel> selTwo(int id){
		return levelService.selTwo(id);
	}
	@RequestMapping("/delTwo")
	@ResponseBody
	public Map<Integer, String> delTwo(int id){
		Map<Integer, String> map = new HashMap<>();
		if (levelService.delLevel(id)>0) {
			map.put(0, "删除成功");
		}
		else {
			map.put(1, "删除失败");
		}
		return map;
	}
	//前端需要传入上一层级 ID ，该层级名称，层级已在 实现层设为 2
		@RequestMapping("/addTwo")
		@ResponseBody
		public Map<Integer, String> addTwo(JsLevel level){
			String name = null;
			try {
				name = new String(level.getName().getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			level.setName(name);
			Map<Integer, String> map = new HashMap<>();
			if (levelService.inLevel(level)>0) {
				map.put(0, "添加成功");
			}
			else {
				map.put(1, "添加失败");
			}
			return map;
		}
}
