package com.zxh.dataexchange;

import com.zxh.dataexchange.bean.User;
import com.zxh.dataexchange.core.annotation.SwitchDataSource;
import com.zxh.dataexchange.core.commons.DataSourceNames;
import com.zxh.dataexchange.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataexchangeApplicationTests {

  @Autowired
  UserService userService;

  @Test
  public void testUser(){


    System.out.println(userService.all());


  }






}
