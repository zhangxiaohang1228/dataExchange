package com.zxh.dataexchange.service;

import com.baomidou.mybatisplus.service.IService;
import com.zxh.dataexchange.bean.User;

import java.util.List;

/**
 * @Author: zxh
 * @Date: 2019/10/24 21:53
 * @desc
 */
public interface UserService extends IService<User> {
  List<User> all();
}
