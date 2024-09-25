package com.boyer.utils;


import java.io.IOException;

public class ResultResponseUtils {

    public static ResponseResult<Object> success(Integer code, String message, Object data) throws IOException{
       return new ResponseResult<Object>(code,message,data);
    }

    public static ResponseResult<Object> success(String message, Object data) throws IOException{
        return success(0,message,data);
    }

    public static ResponseResult<Object> success(Object data) throws IOException{
       return success("成功",data);
    }

    public static ResponseResult<Object> error(Integer code, String message) throws IOException{
       return new ResponseResult<Object>(code,message,null);
    }

    public static ResponseResult<Object> error(String message) throws IOException{
        return error(-1,message);
    }

    public static ResponseResult<Object> error() throws IOException{
       return error("失败");
    }
}
