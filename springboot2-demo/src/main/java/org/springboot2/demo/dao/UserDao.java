package org.springboot2.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springboot2.demo.model.UserDomain;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDao {
    int insert(UserDomain record);
    List<UserDomain> selectUsers();
}
