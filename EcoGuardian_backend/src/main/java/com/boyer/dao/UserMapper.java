package com.boyer.dao;

import com.boyer.pojo.User;

import java.util.List;

public interface UserMapper {
    public int saveUser(User user);
    public List<User> queryUsers();
    public User queryUserById(String userId);
    public int deleteUserById(String userId);
    public int updateUser(User user);
    public User findByIdAndPwd(User user);
}