package com.boyer.filter;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginFilter implements HandlerInterceptor {

    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");

        if (loginUser == null) {
            request.setAttribute("msg", "没有权限，请先登录");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return false;
        }else{
            return true;
        }
    }


}
