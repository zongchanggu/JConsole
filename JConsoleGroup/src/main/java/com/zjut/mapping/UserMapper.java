package com.zjut.mapping;

import com.zjut.pojo.User;

public interface UserMapper {
	public User selectByPrimaryKey(int userId);
}
