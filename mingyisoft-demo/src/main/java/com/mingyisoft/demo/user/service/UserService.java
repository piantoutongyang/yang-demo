package com.mingyisoft.demo.user.service;

import java.util.List;

import com.mingyisoft.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mingyisoft.demo.other.dao.OtherMapper;
import com.mingyisoft.demo.user.dao.UserMapper;
import com.mingyisoft.demo.user.model.User;

@Service
public class UserService extends ServiceImpl<UserMapper, User>{
	@Autowired
    private UserMapper userMapper;
	
//	@Autowired
//    private OtherMapper otherMapper;

//    @DS("ds-svc0")
//    @Transactional 的 user.userName
    public User addUser(User user) {
    	userMapper.insert(user);
        User xxx = (User)RedisUtil.get("xxx");
        RedisUtil.set("xxx",user,15*1000);


    	System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    	
        return user;
    }
    
//    @DS("ds-svc1")
    public User addUser1(User user) {
//    	userMapper.insert(user);
    	System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    	
        return user;
    }
    
    public int addUser2(User user) {
    	userMapper.insert(user);
    	System.out.println(("----- selectAll method test ------"));
//        List<User> userList = otherMapper.selectList(null);
//        userList.forEach(System.out::println);
    	
        return 1;
    }
    
    public int addUser3(User user) {
//    	userMapper.insert(user);
    	System.out.println(("----- selectAll method test ------"));
//        List<User> userList = otherMapper.selectList(null);
//        userList.forEach(System.out::println);
    	
        return 1;
    }

    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
//    @Override
//    public PageInfo<UserDomain> findAllUser(int pageNum, int pageSize) {
//        //将参数传给这个方法就可以实现物理分页了，非常简单。
//        PageHelper.startPage(pageNum, pageSize);
//        List<UserDomain> userDomains = userDao.selectUsers();
//        PageInfo result = new PageInfo(userDomains);
//        if(pageSize==100) {
//        	try {
//				Thread.sleep(50*1000);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//        }
//        return result;
//    }
}

