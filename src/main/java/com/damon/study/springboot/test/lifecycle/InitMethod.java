package com.damon.study.springboot.test.lifecycle;

import javax.annotation.PreDestroy;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
@Getter
public class InitMethod implements InitializingBean, DisposableBean {

  private Logger logger = LoggerFactory.getLogger(InitMethod.class);

  private String name;


  @Override
  public void destroy() throws Exception {
    logger.debug("afterPropertiesSet destroyMethod");
  }

  @Override
  public void afterPropertiesSet() {
    name="afterPropertiesSet";
  }

  @PreDestroy
  public void disposableMethod() {
    logger.debug("disposableMethod destroyMethod");
  }
}
