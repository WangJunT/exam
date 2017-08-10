 package cn.cm.test;


import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class TestMessage {

	@Test
	public void testMe(){
		String check_code = String.valueOf((int)((Math.random()*9+1)*100000));
		String url = "http://gw.api.taobao.com/router/rest";
		String appkey = "23438948";
		String secret ="63bc20bdd35ffaa8a5a0541072324316" ;
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setSmsType("normal");
		req.setSmsFreeSignName("蜻蜓时光");
		req.setSmsParamString("{\"code\":\""+ check_code + "\",\"product\":\"浙江建筑学院\"}");
		req.setRecNum("15927062311");
		req.setSmsTemplateCode("SMS_5955148");
		AlibabaAliqinFcSmsNumSendResponse rsp = null;
		try {
			rsp = client.execute(req);
			JSONObject j = JSONObject.parseObject(rsp.getBody());
			
			if (j.containsKey("error_response")) {
				System.out.println("错误");
			}
			else{
				System.out.println("正确");
			}
		} catch (ApiException e) {
			e.printStackTrace();
		}
		System.out.println(rsp.getBody());
	}
	@Test
	public void t(){
		String s = "{\"alibaba_aliqin_fc_sms_num_send_response\":{\"result\":{\"err_code\":\"0\",\"model\":\"109289857519^1112401640693\",\"msg\":\"*\",\"success\":true},\"request_id\":\"eqi2inhlz7hd\"}}";
		JSONObject j = JSONObject.parseObject(s);
		JSONObject k = j.getJSONObject("error_response");
		System.out.println(k);
		System.out.println(j);
		System.out.println(j.toJSONString());
	}
	@Test
	public void e(){
		//1502341396163
		long time = System.currentTimeMillis();
		long stamp = (time-1502341396163l)/1000;
		System.out.println(stamp);
		System.out.println(stamp>100);
	}
}
