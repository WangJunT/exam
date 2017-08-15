package cm.cn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cm.cn.po.JsUser;

public class LoginInterceptor implements HandlerInterceptor{  
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		 //��ȡ�����URL  
        String url = request.getRequestURI();  
        //URL:login.jsp�ǹ�����;���demo�ǳ���login.jsp�ǿ��Թ������ʵģ�������URL���������ؿ���  
        if(url.indexOf("index")>=0){  
            return true;  
        }  
        //��ȡSession  
        HttpSession session = request.getSession();  
        JsUser jsUser = (JsUser)session.getAttribute("user");  
          
        if(jsUser != null){  
            return true;  
        }  
//        �����������ģ���ת����¼����  
        request.getRequestDispatcher("/index/first.action").forward(request, response);  
          
		return false;
	}  

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	
  
}  
