package cm.cn.util;


import com.alibaba.fastjson.JSONObject;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class GetCheckCode {
	/**
	 * ��ȡ��֤��
	 * @param phone
	 */
	public static boolean getCode(String phone,String check_code){
//		String check_code = String.valueOf((int)((Math.random()*9+1)*100000));
		boolean flag = false;
		String url = "http://gw.api.taobao.com/router/rest";
		String appkey = "23438948";
		String secret ="63bc20bdd35ffaa8a5a0541072324316" ;
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setSmsType("normal");
		req.setSmsFreeSignName("����ʱ��");
		req.setSmsParamString("{\"code\":\""+ check_code + "\",\"product\":\"����ʱ��\"}");
		req.setRecNum(phone);
		req.setSmsTemplateCode("SMS_5955148");
		AlibabaAliqinFcSmsNumSendResponse rsp = null;
		try {
			rsp = client.execute(req);
			JSONObject json =JSONObject.parseObject(rsp.getBody());
			if (json.containsKey("error_response")) {
				System.out.println("����");
			}
			else{
				System.out.println("��ȷ");
				flag = true;
			}
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
