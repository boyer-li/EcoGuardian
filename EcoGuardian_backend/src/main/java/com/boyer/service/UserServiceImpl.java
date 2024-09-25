package com.boyer.service;

import com.boyer.dao.UserMapper;
import com.boyer.pojo.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int saveUser(User user) {
        return userMapper.saveUser(user);
    }

    public List<User> queryUsers() {
        return userMapper.queryUsers();
    }

    public User queryUserById(String userId) {
        return userMapper.queryUserById(userId);
    }

    public int deleteUserById(String userId) {
        return userMapper.deleteUserById(userId);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public User findByIdAndPwd(User user) {
        return userMapper.findByIdAndPwd(user);
    }
}
