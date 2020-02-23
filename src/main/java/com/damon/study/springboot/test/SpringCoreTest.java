package com.damon.study.springboot.test;

import com.damon.study.springboot.test.bean.AspectTestBean;
import com.damon.study.springboot.test.bean.JsrStandardBean;
import com.damon.study.springboot.test.lifecycle.InitMethod;
import java.util.Locale;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Profile("learn")
public class SpringCoreTest implements BeanNameAware {

  @Autowired
  private InitMethod initMethod;
  private String beanName;
  @Autowired
  private JsrStandardBean jsrStandardBean;
  @Autowired
  private Environment environment;
  @Autowired
  private MessageSource messageSource;
  @Autowired
  private AspectTestBean aspectTestBean;

  @PostConstruct
  public void assertMethod() {
    testInitMethod();
  }

  private void testInitMethod() {
    Assert.isTrue(initMethod.getName().equals("afterPropertiesSet"));

    System.out.println("testInitMethod");
    Assert.notNull(beanName);
    Assert.notNull(jsrStandardBean);
    Assert.isTrue(environment.containsProperty("testbean.name"));
    Assert.isTrue("chinese".equals(messageSource.getMessage("conuntry-name",null, Locale.US)));
    //Assert.isTrue(lifeCycleBean.isStartDone());
    aspectTestBean.sayAspectHello();
  }

  @Override
  public void setBeanName(String name) {
    this.beanName=name;
  }
}
