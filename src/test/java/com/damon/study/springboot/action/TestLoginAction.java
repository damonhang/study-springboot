package com.damon.study.springboot.action;

import lombok.Data;

@Data
public class TestLoginAction {
  private String username;
  private String password;

  public TestLoginAction(String username, String password) {
    this.username = username;
    this.password = password;
  }
}
