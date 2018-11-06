/**
 * Copyright (C), 2015-2018,
 * FileName: LoginInterceptor
 * Author:   deng_yt
 * Date:     2018/11/3 21:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/11/3
 * @since 1.0.0
 */
public class LoginInterceptor implements HandlerInterceptor {
  private Logger logger = Logger.getLogger(LoginInterceptor.class);
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    logger.warn("============== 拦截器 pre");
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    logger.warn("============== 拦截器 postHandle");

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    logger.warn("============== 拦截器 afterCompletion");

  }
}
