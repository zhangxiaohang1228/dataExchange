package com.zxh.dataexchange.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zxh.dataexchange.core.annotation.SwitchDataSource;
import com.zxh.dataexchange.core.commons.DataSourceNames;
import com.zxh.dataexchange.mapper.UserMapper;
import com.zxh.dataexchange.bean.User;
import com.zxh.dataexchange.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zxh
 * @Date: 2019/10/24 21:32
 * @desc
 */
@Service
public class UserviceImpl extends ServiceImpl<UserMapper,User> implements UserService {


  @Resource
  private UserMapper userMapper;


  @SwitchDataSource(dataSourceName = DataSourceNames.OTHER)
  public List<User> all(){
    EntityWrapper<User> wrapper = new EntityWrapper<>();
    return userMapper.selectList(wrapper);
  }

}
