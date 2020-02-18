package com.damon.study.springboot.test.factory;

import com.damon.study.springboot.test.annotion.TestBean;
import javax.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Profile;
import org.springframework.util.Assert;

@TestBean
@Profile("learn")
public class FactoryBeanTest implements ApplicationContextAware {

  ApplicationContext applicationContext;

  @PostConstruct
  public void init(){
    FactoryClass bean = applicationContext.getBean(FactoryClass.class);
    Assert.notNull(bean);
    Assert.isInstanceOf(FactoryClass.class,bean);
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext=applicationContext;
  }
}
