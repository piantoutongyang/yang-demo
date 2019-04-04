package org.springboot2.demo.service;

import org.springboot2.demo.model.UserDomain;

import com.github.pagehelper.PageInfo;

public interface UserService {
    int addUser(UserDomain user);
    PageInfo<UserDomain> findAllUser(int pageNum, int pageSize);
}

