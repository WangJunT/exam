package cm.cn.util;

import java.util.List;

public class RandomAndSpiltUtil {
	/**
	 * 返回一个 0 到 50 的数
	 * @return
	 */
	public static int RandomInt(){
		int num = (int) (Math.random()*50);
		return num;
	}
	/**
	 * 将字符串变成字符数组
	 */
	public static String[] strToArray(String str){
		String[] array = null;
		array = str.split(",");
		return array;
	}
	/**
	 * 将list集合变成 字符数组
	 * @param list
	 * @return
	 */
	public static String[] listtoStr(List<String> list){
		String strings[]=new String[list.size()];
		for (int i=0 ; i<list.size() ; i++){
			strings[i] = list.get(i);
		}
		return strings;
	}
	/**
	 * 将字符数组转换为字符串
	 * @param array
	 * @return
	 */
	public static String arrayToStr(String[] array){
		StringBuilder stringBuilder = new StringBuilder();
		for(String string : array){
			stringBuilder.append(string+",");
		}
		return stringBuilder.toString();
		
	}
}
