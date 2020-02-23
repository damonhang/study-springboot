package com.damon.study.springboot.test.bean;

import javax.annotation.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@ManagedBean("jsrStandardBean")
public class JsrStandardBean {

  @Autowired
  @Qualifier("qualifier")
  private CommonTestBean commonTestBean;

}
