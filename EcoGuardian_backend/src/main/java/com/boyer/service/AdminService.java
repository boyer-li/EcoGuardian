package com.boyer.service;

import com.boyer.pojo.Admin;

public interface AdminService {
    public Admin queryAdminById(String adminId);
    public Admin findByIdAndPwd(Admin admin);
    public int updateAdmin(Admin admin);
}
