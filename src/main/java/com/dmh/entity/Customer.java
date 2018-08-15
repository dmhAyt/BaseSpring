/**
 * Copyright (C), 2015-2018,
 * FileName: Customer
 * Author:   deng_yt
 * Date:     2018/8/14 16:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.entity;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author deng_yt
 * @create 2018/8/14
 * @since 1.0.0
 */
public class Customer {

  private String name;
  private String code;
  private String pass;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "name='" + name + '\'' +
        ", code='" + code + '\'' +
        ", pass='" + pass + '\'' +
        '}';
  }
}
