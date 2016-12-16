package com.zjut.service;

import java.util.List;

import com.zjut.pojo.User;

public interface IUserService {
    public User getUserById(int userId);
    
    public List<User> getPageUserListByFL(int firstrow, int lastrow);
    
    public int getTotalNum();
}
