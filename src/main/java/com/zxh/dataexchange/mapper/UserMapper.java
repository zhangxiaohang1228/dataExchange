package com.zxh.dataexchange.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zxh.dataexchange.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zxh
 * @Date: 2019/10/24 21:53
 * @desc
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
