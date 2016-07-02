package br.ufc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class AutorizadorFiltro implements Filter{

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, 
						 ServletResponse response,
						 FilterChain chain) throws IOException, ServletException {
	
		String uri = ((HttpServletRequest)request).getRequestURI();
		
		//if para a URI
		//senao if para ver se tem alguem logado na session
		//senao response.redirect
		
		long tinicial = System.currentTimeMillis();
		chain.doFilter(request, response);
		long tfinal = System.currentTimeMillis();
		System.out.println(uri+" : " + (tfinal-tinicial));
		
	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}
