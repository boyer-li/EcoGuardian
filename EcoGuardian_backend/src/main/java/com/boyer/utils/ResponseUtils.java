package com.boyer.utils;


import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtils {
    private static void print(HttpServletResponse resp, String json) throws IOException {
        resp.setContentType("text/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().append(json);
    }

    public static void success(HttpServletResponse resp, Integer code, String message, Object data) throws IOException{
        ResponseResult<Object> result = new ResponseResult<Object>(code,message,data);
        String json = (new Gson()).toJson(result);
        print(resp,json);
    }

    public static void success(HttpServletResponse resp, String message, Object data) throws IOException{
        success(resp,0,message,data);
    }

    public static void success(HttpServletResponse resp, Object data) throws IOException{
        success(resp,"成功",data);
    }

    public static void error(HttpServletResponse resp, Integer code, String message) throws IOException{
        ResponseResult<Object> result = new ResponseResult<Object>(code,message,null);
        String json = (new Gson()).toJson(result);
        print(resp,json);
    }

    public static void error(HttpServletResponse resp, String message) throws IOException{
        error(resp, -1,message);
    }

    public static void error(HttpServletResponse resp) throws IOException{
        error(resp,"失败");
    }
}
