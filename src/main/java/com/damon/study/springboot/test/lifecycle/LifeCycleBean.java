package com.damon.study.springboot.test.lifecycle;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
@Getter
public class LifeCycleBean implements SmartLifecycle {
  private Logger logger= LoggerFactory.getLogger(LifeCycleBean.class);

  private boolean startDone=false;
  private boolean isRunning = false;

  @Override
  public void start() {
    System.out.println("LifeCycleBean");
    isRunning = true;
  }

  @Override
  public void stop() {
    System.out.println("stop(Runnable)");
    isRunning = false;
  }

  @Override
  public boolean isRunning() {
    return isRunning;
  }
}
