package cm.cn.util;

import java.util.List;

public class RandomAndSpiltUtil {
	/**
	 * ����һ�� 0 �� 50 ����
	 * @return
	 */
	public static int RandomInt(){
		int num = (int) (Math.random()*50);
		return num;
	}
	/**
	 * ���ַ�������ַ�����
	 */
	public static String[] strToArray(String str){
		String[] array = null;
		array = str.split(",");
		return array;
	}
	/**
	 * ��list���ϱ�� �ַ�����
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
	 * ���ַ�����ת��Ϊ�ַ���
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
