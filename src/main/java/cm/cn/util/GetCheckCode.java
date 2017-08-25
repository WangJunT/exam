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
	/*public static boolean getCode(String phone,String check_code){
		boolean flag = false;
		//���ó�ʱʱ��-�����е���
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
		//��ʼ��ascClient��Ҫ�ļ�������
		final String product = "Dysmsapi";//����API��Ʒ���ƣ����Ų�Ʒ���̶��������޸ģ�
		final String domain = "dysmsapi.aliyuncs.com";//����API��Ʒ�������ӿڵ�ַ�̶��������޸ģ�
		//�滻�����AK
		final String accessKeyId = "LTAIxffZhELQUPHJ";//���accessKeyId,�ο����ĵ�����2
		final String accessKeySecret = "wYyDyI7lhYk6SmwvxFXWqzvpHowi7f";//���accessKeySecret���ο����ĵ�����2
		//��ʼ��ascClient,��ʱ��֧�ֶ�region
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
		accessKeySecret);
		try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IAcsClient acsClient = new DefaultAcsClient(profile);
		 //��װ�������
		 SendSmsRequest request = new SendSmsRequest();
		 //ʹ��post�ύ
		 request.setMethod(MethodType.POST);
		 //����:�������ֻ��š�֧���Զ��ŷָ�����ʽ�����������ã���������Ϊ1000���ֻ�����,������������ڵ������ü�ʱ�������ӳ�,��֤�����͵Ķ����Ƽ�ʹ�õ������õķ�ʽ
		 request.setPhoneNumbers("phone");
		 //����:����ǩ��-���ڶ��ſ���̨���ҵ�
		 request.setSignName("�㽭����ְҵ������ѵѧУ");
		 //����:����ģ��-���ڶ��ſ���̨���ҵ�
		 request.setTemplateCode("SMS_86800019");
		 //��ѡ:ģ���еı����滻JSON��,��ģ������Ϊ"�װ���${name},������֤��Ϊ${code}"ʱ,�˴���ֵΪ
		 //������ʾ:���JSON����Ҫ�����з�,����ձ�׼��JSONЭ��Ի��з���Ҫ��,������������а���\r\n�������JSON����Ҫ��ʾ��\\r\\n,����ᵼ��JSON�ڷ���˽���ʧ��
		 //"{\"code\":\""+ check_code + "\",\"product\":\"����ʱ��\"}"
		 request.setTemplateParam("{\"name\":\"�㽭����ְҵ������ѵѧУ\", \"code\":\""+ check_code + "\"}");
		 //��ѡ-���ж�����չ��(�����������û�����Դ��ֶ�)
		 //request.setSmsUpExtendCode("90997");
		 //��ѡ:outIdΪ�ṩ��ҵ����չ�ֶ�,�����ڶ��Ż�ִ��Ϣ�н���ֵ���ظ�������
//		 request.setOutId("yourOutId");
		//����ʧ���������ClientException�쳣
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
