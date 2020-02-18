package com.damon.study.springboot.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectConfiguration {

  private static final int DEFAULT_MAX_RETRIES = 2;

  private int maxRetries = DEFAULT_MAX_RETRIES;
  private int order = 1;

  public void setMaxRetries(int maxRetries) {
    this.maxRetries = maxRetries;
  }

  public int getOrder() {
    return this.order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  @Before("target(com.damon.study.springboot.bean.AspectTestBean)")
  public void doAccessCheck() {
    System.out.println("aspect doAccessCheck");
  }

  @Around("com.damon.study.springboot.bean.AspectTestBean.sayAspectHello()")
  public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable {
    int numAttempts = 0;
    do {
      numAttempts++;
      try {
        return pjp.proceed();
      } catch (Exception ex) {
      }
    } while (numAttempts <= this.maxRetries);
    return numAttempts;
  }

}
