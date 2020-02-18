package com.damon.study.springboot.bean;

import lombok.Data;

@Data
public class CommonUser {
  private String userName;
  private String password;


  public CommonUser(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }
}
