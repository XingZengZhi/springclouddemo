package com.example.servicezuul.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Description: 自定义过滤
 * date:  </br>
 *
 * @author </br>
 */
@Component
public class MyFilter extends ZuulFilter {

	private static Logger logger = LoggerFactory.getLogger(MyFilter.class);

	/**
	 * pre 路由之前
	 * routing 路由之时
	 * post 路由之后
	 * error 发送错误调用
	 * @return
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 过滤的顺序
	 * @return
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * 可以写逻辑判断，是否要过滤，true永远过滤
	 * @return
	 */
	@Override
	public boolean shouldFilter() {
		return false;
	}

	/**
	 * 过滤器的具体逻辑，可用很复杂，包括查SQL，nosql去判断该请求到底有没有权限访问
	 * @return
	 * @throws ZuulException
	 */
	@Override
	public Object run() throws ZuulException {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		logger.info("%s >> %s", request.getMethod(), request.getRequestURL().toString());
		Object token = request.getParameter("token");
		if(token == null) {
			logger.warn("token is empty");
			requestContext.setSendZuulResponse(false);
			requestContext.setResponseStatusCode(401);
			try {
				requestContext.getResponse().getWriter().write("token is empty");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		logger.info("OK");
		return null;
	}
}
