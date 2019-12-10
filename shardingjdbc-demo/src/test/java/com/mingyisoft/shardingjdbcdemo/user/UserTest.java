package com.mingyisoft.shardingjdbcdemo.user;

import com.mingyisoft.shardingjdbcdemo.user.entity.UserDO;
import com.mingyisoft.shardingjdbcdemo.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {
    @Autowired
    UserService userService;

    @Test
    public void aaa(){
        UserDO user = new UserDO();
        userService.addUser(user);

        String aaa = "xxx";
        System.out.println(aaa);
    }
}
