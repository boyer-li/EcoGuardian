package com.boyer.controller;

import com.boyer.pojo.User;
import com.boyer.service.UserServiceImpl;
import com.boyer.utils.CacheUtils;
import com.boyer.utils.ResultResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserServiceImpl userService;

    //查找全部用户
    @RequestMapping(value = "/findUsers",produces = "application/json",method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult<Object> findUsers() throws IOException {
        System.out.println("访问了查找用户列表");
        List<User> list = userService.queryUsers();
        System.out.println(list);
        if(!list.isEmpty()){
            String token = UUID.randomUUID().toString().replace("-","");
            CacheUtils.put(token,list);
            System.out.println(list);
            return   ResultResponseUtils.success(token,list);
        }else{
            return ResultResponseUtils.error("查找所有用户失败");
        }
    }

    //增加用户
    @RequestMapping(value = "/addUser",consumes = "application/json",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseResult<Object> addUser(@RequestBody User user) throws IOException{
        System.out.println("访问了增加用户");
        if(!StringUtils.isEmpty(user)){
            userService.saveUser(user);
            String token = UUID.randomUUID().toString().replace("-","");
            CacheUtils.put(token,null);
            System.out.println("添加了"+user);
            return   ResultResponseUtils.success(token);
        }else{
            return ResultResponseUtils.error("添加用户失败");
        }
    }

    //查找用户
    @RequestMapping(value = "/findUserById",consumes = "application/json",produces = "application/json",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Object> findUserById(@RequestBody User user) throws IOException{
        System.out.println("访问了查询用户");
        if(!StringUtils.isEmpty(user)){
            User user1 = userService.queryUserById(user.getUser_id());
            String token = UUID.randomUUID().toString().replace("-","");
            CacheUtils.put(token,user1);
            System.out.println("查询了"+user1);
            return   ResultResponseUtils.success(token,user1);
        }else{
            return ResultResponseUtils.error("查询用户失败");
        }
    }

    //删除用户
    @RequestMapping(value = "/deleteUser",consumes = "application/json",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseResult<Object> deleteUser(@RequestBody User user) throws IOException{
        System.out.println("访问了删除用户");
        if(!StringUtils.isEmpty(user)){
            userService.deleteUserById(user.getUser_id());
            String token = UUID.randomUUID().toString().replace("-","");
            CacheUtils.put(token,null);
            return   ResultResponseUtils.success(token);
        }else{
            return ResultResponseUtils.error("删除用户失败,未查询到用户");
        }
    }

    //更新用户
    @RequestMapping(value = "/updateUser",consumes = "application/json",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseResult<Object> updateUser(@RequestBody User user) throws IOException{
        System.out.println("访问了更新用户");
        if(!StringUtils.isEmpty(user)){
            userService.updateUser(user);
            String token = UUID.randomUUID().toString().replace("-","");
            CacheUtils.put(token,null);
            return   ResultResponseUtils.success(token);
        }else{
            return ResultResponseUtils.error("更新用户失败，未获取到用户");
        }
    }

}
