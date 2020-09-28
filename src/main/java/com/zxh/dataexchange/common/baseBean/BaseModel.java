package com.zxh.dataexchange.common.baseBean;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

/**
 * @Author: zxh
 * @Date: 2019/11/2 14:41
 * @desc
 */
public class BaseModel<T extends Model> extends Model<T> {
  @Override
  protected Serializable pkVal() {
    return null;
  }
}
