package com.boyer.controller;

import com.boyer.pojo.Admin;
import com.boyer.service.AdminService;
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
import java.util.UUID;

@Controller
public class AdminController {

    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminService adminService;

    //判断是否是管理员
    @RequestMapping(value = "/findAdminById",consumes = "application/json",produces = "application/json",method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult<Object> findAdminById(@RequestBody Admin admin) throws IOException {

        if(!StringUtils.isEmpty(admin)){
           Admin admin1 = adminService.queryAdminById(admin.getAdmin_id());
            String token = UUID.randomUUID().toString().replace("-","");
            CacheUtils.put(token,admin1);

            return   ResultResponseUtils.success(token,admin1);
        }else{

        }
    }



}
