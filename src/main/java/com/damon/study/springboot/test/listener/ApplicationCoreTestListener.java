package com.damon.study.springboot.test.listener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationCoreTestListener implements ApplicationContextAware, ApplicationListener {
  private ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext=applicationContext;
  }

  @Override
  public void onApplicationEvent(ApplicationEvent event) {
    if(applicationContext!=null){
      System.out.println(applicationContext.getApplicationName());
    }
    System.out.println(event.getClass().getName());
  }
}
