package cm.cn.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class MyCrosFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override 
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException { 
		HttpServletResponse response = (HttpServletResponse) servletResponse; 
//		String origin = (String) servletRequest.getRemoteHost()+":"+servletRequest.getRemotePort(); 
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE"); 
		response.setHeader("Access-Control-Max-Age", "3600"); 
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, HaiYi-Access-Token"); 
		response.setHeader("Access-Control-Allow-Credentials","true"); 
		filterChain.doFilter(servletRequest, servletResponse); 
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
