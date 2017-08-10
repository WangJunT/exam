package cm.cn.util;

import java.util.List;

import cm.cn.po.JsQuesion;

public class ListTransfrom {
	/**
	 * 
	 * @param list
	 * @param type 只能为1,2 1返回题目 id ,2返回答案
	 * @return
	 */
	public static String[] listQuestionToArray(List<JsQuesion> list,int type){
		String strings[]=new String[list.size()];
		if(type==1){
			for (int i=0 ; i<list.size() ; i++){
				JsQuesion jsQuesion = list.get(i);
				strings[i] = String.valueOf(jsQuesion.getId());
			}
		}else{
			for (int i=0 ; i<list.size() ; i++){
				JsQuesion jsQuesion = list.get(i);
				strings[i] = jsQuesion.getAnswer();
			}
		}
		return strings;
	}
}
