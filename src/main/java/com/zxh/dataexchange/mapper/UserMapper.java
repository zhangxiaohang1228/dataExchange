package com.zxh.dataexchange.mapper;

import com.zxh.dataexchange.bean.User;

import java.util.List;

/**
 * @Author: zxh
 * @Date: 2019/10/16 21:30
 * @desc
 */
public interface UserMapper {

  List<User> findAll();
}
