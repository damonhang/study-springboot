package com.damon.study.springboot.bean;

public class TestBean {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TestBean(String protectedInstance, int i) {

  }

  public TestBean(String publicInstance) {

  }

  public void setSpouse(TestBean spouse) {

  }

  public void setCountry(String country) {

  }
}
