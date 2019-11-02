package com.zxh.dataexchange.controller.loginController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: zxh
 * @Date: 2019-10-16 16:34
 * @Description: 登录
 */
@Controller
public class LoginController {

    //todo 多线程读取库，热处理数据

  @RequestMapping("/")
  public String toLogin(){
    return "index1";
  }

}
