/**
 * Copyright (C), 2015-2018,
 * FileName: User
 * Author:   deng_yt
 * Date:     2018/8/14 16:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.dto;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author deng_yt
 * @create 2018/8/14
 * @since 1.0.0
 */
public class User {
  /**
   *  容量， 单位为 m
   */
  public static final double CAPACITY = 102400f;
  public static final String LEGAL = "Y";
  public static final String ILLEGAL = "N";

  private Integer id;
  private String userCode;
  private String userName;
  private String userPass;
  private double accountCapacity = CAPACITY;
  private double usedCapacity = 0.0f;
  private Date accountCreateDate;
  private Date accountAlterDate;
  private String accountIsLegitimate = LEGAL;
  private String legitimateDescription;

  public User(){

  }

  public User(String userCode, String userName, String userPass, double accountCapacity,
      double usedCapacity, Date accountCreateDate, Date accountAlterDate,
      String accountIsLegitimate, String legitimateDescription) {
    this.userCode = userCode;
    this.userName = userName;
    this.userPass = userPass;
    this.accountCapacity = accountCapacity;
    this.usedCapacity = usedCapacity;
    this.accountCreateDate = accountCreateDate;
    this.accountAlterDate = accountAlterDate;
    this.accountIsLegitimate = accountIsLegitimate;
    this.legitimateDescription = legitimateDescription;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPass() {
    return userPass;
  }

  public void setUserPass(String userPass) {
    this.userPass = userPass;
  }

  public double getAccountCapacity() {
    return accountCapacity;
  }

  public void setAccountCapacity(double accountCapacity) {
    this.accountCapacity = accountCapacity;
  }

  public double getUsedCapacity() {
    return usedCapacity;
  }

  public void setUsedCapacity(double usedCapacity) {
    this.usedCapacity = usedCapacity;
  }

  public Date getAccountCreateDate() {
    return accountCreateDate;
  }

  public void setAccountCreateDate(Date accountCreateDate) {
    this.accountCreateDate = accountCreateDate;
  }

  public Date getAccountAlterDate() {
    return accountAlterDate;
  }

  public void setAccountAlterDate(Date accountAlterDate) {
    this.accountAlterDate = accountAlterDate;
  }

  public String getAccountIsLegitimate() {
    return accountIsLegitimate;
  }

  public void setAccountIsLegitimate(String accountIsLegitimate) {
    this.accountIsLegitimate = accountIsLegitimate;
  }

  public String getLegitimateDescription() {
    return legitimateDescription;
  }

  public void setLegitimateDescription(String legitimateDescription) {
    this.legitimateDescription = legitimateDescription;
  }

  @Override
  public String toString() {
    return "{" +
        "id=" + id +
        ", userCode='" + userCode + '\'' +
        ", userName='" + userName + '\'' +
        ", userPass='" + userPass + '\'' +
        ", accountCapacity=" + accountCapacity +
        ", usedCapacity=" + usedCapacity +
        ", accountCreateDate=" + accountCreateDate +
        ", accountAlterDate=" + accountAlterDate +
        ", accountIsLegitimate='" + accountIsLegitimate + '\'' +
        ", legitimateDescription='" + legitimateDescription + '\'' +
        '}';
  }
}
