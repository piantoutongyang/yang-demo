package org.mingyisoft.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mingyisoft.demo.user.model.User;


@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {
//  @Autowired
//  UserService userService;
  
  @Test
  public void testLoadTest() {
	  System.out.println(12345);
	  
  }
}
