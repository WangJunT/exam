package cm.cn.util;

import com.alibaba.fastjson.JSONObject;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

//import com.aliyuncs.DefaultAcsClient;
//import com.aliyuncs.IAcsClient;
//import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
//import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
//import com.aliyuncs.exceptions.ClientException;
//import com.aliyuncs.http.MethodType;
//import com.aliyuncs.profile.DefaultProfile;
//import com.aliyuncs.profile.IClientProfile;

public class GetCheckCode {
	/**
	 * 获取验证码
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
		req.setSmsFreeSignName("蜻蜓时光");
		req.setSmsParamString("{\"code\":\""+ check_code + "\",\"product\":\"蜻蜓时光\"}");
		req.setRecNum(phone);
		req.setSmsTemplateCode("SMS_5955148");
		AlibabaAliqinFcSmsNumSendResponse rsp = null;
		try {
			rsp = client.execute(req);
			JSONObject json =JSONObject.parseObject(rsp.getBody());
			if (json.containsKey("error_response")) {
				System.out.println("错误");
			}
			else{
				System.out.println("正确");
				flag = true;
			}
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return flag;
	}
	/*public static boolean getCode(String phone,String check_code){
		boolean flag = false;
		//设置超时时间-可自行调整
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
		//初始化ascClient需要的几个参数
		final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
		final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
		//替换成你的AK
		final String accessKeyId = "LTAIxffZhELQUPHJ";//你的accessKeyId,参考本文档步骤2
		final String accessKeySecret = "wYyDyI7lhYk6SmwvxFXWqzvpHowi7f";//你的accessKeySecret，参考本文档步骤2
		//初始化ascClient,暂时不支持多region
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
		accessKeySecret);
		try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IAcsClient acsClient = new DefaultAcsClient(profile);
		 //组装请求对象
		 SendSmsRequest request = new SendSmsRequest();
		 //使用post提交
		 request.setMethod(MethodType.POST);
		 //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
		 request.setPhoneNumbers("phone");
		 //必填:短信签名-可在短信控制台中找到
		 request.setSignName("浙江建设职业技能培训学校");
		 //必填:短信模板-可在短信控制台中找到
		 request.setTemplateCode("SMS_86800019");
		 //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
		 //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
		 //"{\"code\":\""+ check_code + "\",\"product\":\"蜻蜓时光\"}"
		 request.setTemplateParam("{\"name\":\"浙江建设职业技能培训学校\", \"code\":\""+ check_code + "\"}");
		 //可选-上行短信扩展码(无特殊需求用户请忽略此字段)
		 //request.setSmsUpExtendCode("90997");
		 //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
//		 request.setOutId("yourOutId");
		//请求失败这里会抛ClientException异常
		SendSmsResponse sendSmsResponse = new SendSmsResponse();
		try {
			sendSmsResponse = acsClient.getAcsResponse(request);
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
			flag = true ;
		}
		return flag;
	}*/
}
