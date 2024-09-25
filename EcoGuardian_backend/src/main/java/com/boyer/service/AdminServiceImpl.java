package com.boyer.service;

import com.boyer.dao.AdminMapper;
import com.boyer.pojo.Admin;

public class AdminServiceImpl implements AdminService {
    private AdminMapper adminMapper;

    public Admin queryAdminById(String adminId) {
        return adminMapper.queryAdminById(adminId);
    }

    public Admin findByIdAndPwd(Admin admin) {
        return adminMapper.findByIdAndPwd(admin);
    }

    public int updateAdmin(Admin admin){
        return adminMapper.updateAdmin(admin);
    }

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

}
