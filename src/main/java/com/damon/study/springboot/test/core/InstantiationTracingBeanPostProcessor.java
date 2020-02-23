package com.damon.study.springboot.test.core;

import com.damon.study.springboot.test.lifecycle.InitMethod;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {

  // simply return the instantiated bean as-is
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) {
    return bean; // we could potentially return any object reference here...
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) {
    if(bean instanceof InitMethod){
      System.out.println("Bean '" + beanName + "' created : " + bean.toString());
    }
    return bean;
  }
}
