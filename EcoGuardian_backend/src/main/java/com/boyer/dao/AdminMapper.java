package com.boyer.dao;
import com.boyer.pojo.Admin;

public interface AdminMapper {
     public Admin queryAdminById(String adminId);
     public Admin findByIdAndPwd(Admin admin);
     public int updateAdmin(Admin admin);
}
