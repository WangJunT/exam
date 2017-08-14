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
		 //获取请求的URL  
        String url = request.getRequestURI();  
        //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制  
        if(url.indexOf("index")>=0){  
            return true;  
        }  
        //获取Session  
        HttpSession session = request.getSession();  
        JsUser jsUser = (JsUser)session.getAttribute("user");  
          
        if(jsUser != null){  
            return true;  
        }  
        //不符合条件的，跳转到登录界面  
//        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);  
          
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
