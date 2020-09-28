package com.zxh.dataexchange.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.zxh.dataexchange.common.baseBean.BaseModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: zxh
 * @Date: 2019/10/16 23:05
 * @desc
 */
@TableName("user")
@Data
public class User extends BaseModel<User> {

  @TableId(type = IdType.AUTO)
  private Integer id;

  private String userName;

  private String sex;

  private Integer age;

  private String idCard;

  private String address;

  private BigDecimal height;

  private BigDecimal weight;

  private String nationality;

  private String memo;

  private String userCode;

  private Integer isDel;

  private String status;

}
