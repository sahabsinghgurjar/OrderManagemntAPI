package com.sahab.ordermanagement.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AjaxCorsFilter implements Filter {
	@Value("${allowedOrigin}")
	private String allowedOrigin;
	public AjaxCorsFilter() {
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		response.addHeader("Access-Control-Allow-Origin", allowedOrigin);
		response.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");
		response.addHeader("Access-Control-Allow-Headers", "*");
		if (request.getMethod().equals("OPTIONS")) {
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			return;
		}
		chain.doFilter(req, resp);
	}
}