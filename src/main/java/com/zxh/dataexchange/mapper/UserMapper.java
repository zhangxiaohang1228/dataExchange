package com.zxh.dataexchange.mapper;

import com.zxh.dataexchange.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.JpaParameters;

/**
 * @Author: zxh
 * @Date: 2019/10/16 21:30
 * @desc
 */
public interface UserMapper extends JpaRepository<User,Integer> {
}
