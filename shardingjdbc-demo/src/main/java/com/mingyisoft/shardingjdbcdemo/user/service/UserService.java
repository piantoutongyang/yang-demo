package com.mingyisoft.shardingjdbcdemo.user.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mingyisoft.shardingjdbcdemo.user.dao.UserMapper;
import com.mingyisoft.shardingjdbcdemo.user.entity.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper, UserDO>{
	@Autowired
    private UserMapper userMapper;
	
//	@Autowired
//    private OtherMapper otherMapper;

//    @DS("ds-svc0")

    /**
     * Sharding-JDBC自动判断，如果有事务的读+写，则走主库。
     * @param user
     * @return
     */
    @Transactional
    public UserDO addUser(UserDO user) {
//    	userMapper.insert(user);

    	System.out.println(("----- selectAll method test ------"));
        List<UserDO> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    	
        return user;
    }

    /**
     * Sharding-JDBC自动判断，如果有事务的读，则走从库。
     * @param user
     * @return
     */
    @Transactional
    public UserDO addUserxxx(UserDO user) {
        System.out.println(("----- selectAll method test ------"));
        List<UserDO> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
        return user;
    }

    /**
     * Sharding-JDBC自动判断，如果没有事务的读，则走从库。
     * @param user
     * @return
     */
    public UserDO addUser1(UserDO user) {
//    	userMapper.insert(user);
    	System.out.println(("----- selectAll method test ------"));
        List<UserDO> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    	
        return user;
    }
    
//    public int addUser2(UserDO user) {
//    	userMapper.insert(user);
//    	System.out.println(("----- selectAll method test ------"));
//        List<UserDO> userList = otherMapper.selectList(null);
//        userList.forEach(System.out::println);
//
//        return 1;
//    }
    
//    public int addUser3(User user) {
////    	userMapper.insert(user);
//    	System.out.println(("----- selectAll method test ------"));
//        List<User> userList = otherMapper.selectList(null);
//        userList.forEach(System.out::println);
//
//        return 1;
//    }

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

