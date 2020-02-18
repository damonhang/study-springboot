package com.damon.study.springboot.test;

import com.damon.study.springboot.test.lifecycle.InitMethod;
import com.damon.study.springboot.test.lifecycle.LifeCycleBean;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class SpringCoreTest {

  @Autowired
  private InitMethod initMethod;
  @Autowired
  private LifeCycleBean lifeCycleBean;

  @PostConstruct
  public void assertMethod() {
    testInitMethod();
  }

  private void testInitMethod() {
    Assert.isTrue(initMethod.getName().equals("afterPropertiesSet"));

    System.out.println("testInitMethod");
    //Assert.isTrue(lifeCycleBean.isStartDone());
  }
}
