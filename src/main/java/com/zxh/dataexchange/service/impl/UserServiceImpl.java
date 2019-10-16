package com.zxh.dataexchange.service.impl;

import com.zxh.dataexchange.bean.User;
import com.zxh.dataexchange.mapper.UserMapper;
import com.zxh.dataexchange.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zxh
 * @Date: 2019/10/16 21:43
 * @desc
 */
@Service
public class UserServiceImpl implements UserService {

  @Resource
  UserMapper userMapper;

  public List<User> selectAll(){
    return userMapper.findAll();
  }


}
