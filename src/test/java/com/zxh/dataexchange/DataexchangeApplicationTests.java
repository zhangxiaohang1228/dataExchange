package com.zxh.dataexchange;

import com.zxh.dataexchange.bean.User;
import com.zxh.dataexchange.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataexchangeApplicationTests {

  @Autowired
  UserService userService;

  @Test
  public void testUser(){

    List<User> users = userService.selectAll();

    System.out.println(users);


  }






}
