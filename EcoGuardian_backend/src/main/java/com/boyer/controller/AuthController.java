package com.boyer.controller;

import com.boyer.pojo.Admin;
import com.boyer.pojo.User;
import com.boyer.service.AdminService;
import com.boyer.service.UserService;
import com.boyer.utils.CacheUtils;
import com.boyer.utils.ResultResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@Controller
public class AuthController {

    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminService adminService;

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    private Admin admin;
    private User user;

    //用户登录
    @RequestMapping(value = "/userlogin",consumes = "application/json",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Object> userlogin(@RequestBody User user) throws IOException {
        User user1 = userService.findByIdAndPwd(user);
        System.out.println(user);
        System.out.println(user1);

        if(!StringUtils.isEmpty(user1)){
            Object object = CacheUtils.get(user1.getUser_token(),null);
            if(!StringUtils.isEmpty(object)){
                return ResultResponseUtils.error("logined");
            }else{
                //查询到用户
                String token = UUID.randomUUID().toString().replace("-","");
                user1.setUser_token(token);
                userService.updateUser(user1);
                CacheUtils.put(token,user1);
                return   ResultResponseUtils.success(token,user1);
            }
        }else{
            return ResultResponseUtils.error("用户登录失败,用户不存在");
        }
    }

    //logout
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Object> logout(@RequestHeader("token") String token) throws IOException {
        System.out.println("访问了注销："+token);
        Object obj = CacheUtils.get(token,null);
        System.out.println("obj:"+obj);
        if(StringUtils.isEmpty(obj)){
            return ResultResponseUtils.error("未登录,不能注销");
        }else{
//            if(obj.equals(admin)){
//                ((Admin) obj).setAdmin_token("null");
//                System.out.println("访问admin");
//                adminService.updateAdmin((Admin) obj);
//            }else if(obj.equals(user)){
//                ((User) obj).setUser_token("null");
//                System.out.println("访问user");
//                userService.updateUser((User) obj);
//            }
            CacheUtils.remove(token);
            System.out.println("注销成功");

            return ResultResponseUtils.success("注销成功");
        }
    }

    //管理员登录
    @RequestMapping(value = "/adminlogin",consumes = "application/json",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Object> adminlogin(@RequestBody Admin admin) throws IOException {
        System.out.println("访问了管理员登录");
        Admin admin1 = adminService.findByIdAndPwd(admin);
        System.out.println(admin1);

        if(!StringUtils.isEmpty(admin1)){
            Object object = CacheUtils.get(admin1.getAdmin_token(),null);
            if(!StringUtils.isEmpty(object)){
                System.out.println("已经登陆");
                return ResultResponseUtils.error("logined");
            }else{
                //查询到用户
                String token = UUID.randomUUID().toString().replace("-","");
                admin1.setAdmin_token(token);
                adminService.updateAdmin(admin1);
                CacheUtils.put(token,admin1);
                System.out.println("管理员登录了:"+admin1);
                return   ResultResponseUtils.success(token,admin1);

            }
        }else{
            return ResultResponseUtils.error("管理员登录失败");
        }
    }

    //用户注册
    @RequestMapping(value = "/register",consumes = "application/json",produces = "application/json",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseResult<Object> register(@RequestBody User user) throws IOException {
        System.out.print("访问了注册:");
        if(StringUtils.isEmpty(userService.queryUserById(user.getUser_id()))&&!StringUtils.isEmpty(user.getUser_id())){
            userService.saveUser(user);
            String token = UUID.randomUUID().toString().replace("-","");
            CacheUtils.put(token,user);
            System.out.println("新用户注册了:"+user);
            return   ResultResponseUtils.success(token,user);
        }else{
            System.out.print("用户注册失败了");
            return ResultResponseUtils.error("用户注册失败，用户已存在，或用户信息为空");
        }
    }


}
