package com.zxh.dataexchange.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * @Author: zxh
 * @Date: 2019/10/16 23:05
 * @desc
 */
@TableName("user")
public class User extends Model<User> {

  @TableId(type = IdType.AUTO)
  private Integer id;

  private String name;

  private String sex;

  private Integer age;




  @Override
  protected Serializable pkVal() {
    return null;
  }


  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", sex='" + sex + '\'' +
            ", age=" + age +
            '}';
  }
}
