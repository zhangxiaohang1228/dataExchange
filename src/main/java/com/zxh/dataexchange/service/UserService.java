package com.zxh.dataexchange.service;

import com.zxh.dataexchange.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zxh
 * @Date: 2019/10/16 21:43
 * @desc
 */
@Service
public interface UserService {

  public List<User> selectAll();
}
