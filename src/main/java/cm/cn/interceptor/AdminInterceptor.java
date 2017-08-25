package cm.cn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cm.cn.po.JsUser;

public class AdminInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
        String url = request.getRequestURI();  
        if(url.indexOf("index")>=0){  
            return true;  
        }  
        HttpSession session = request.getSession();  
        JsUser jsUser = (JsUser)session.getAttribute("user");  
          
        if(jsUser != null && (jsUser.getRoleId()!=3)){  
            return true;  
        }  
        request.getRequestDispatcher("/index/first.action").forward(request, response);  
          
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
