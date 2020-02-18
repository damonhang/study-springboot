package com.damon.study.springboot.service.impl;

import com.damon.study.springboot.action.TestLoginAction;
import javax.servlet.http.HttpServletRequest;

public class SimpleUserService {

  private TestLoginAction testLoginAction;

  public SimpleUserService(TestLoginAction testLoginAction) {
    this.testLoginAction = testLoginAction;
  }

  public LoginResults loginUser() {
//    if(testLoginAction.getUsername().equals(""))
    return new LoginResults();
  }

  public static class LoginResults {
    private boolean success;

    public boolean isSuccess() {
      return success;
    }

    public void setSuccess(boolean success) {
      this.success = success;
    }
  }
}
