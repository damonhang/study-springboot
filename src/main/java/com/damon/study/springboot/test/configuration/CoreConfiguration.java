package com.damon.study.springboot.test.configuration;

import com.damon.study.springboot.test.core.InstantiationTracingBeanPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("learn")
@ConditionalOnMissingBean(CoreConfiguration.class)
public class CoreConfiguration {

  //  @Bean
//  public DefaultLifecycleProcessor defaultLifecycleProcessor(){
//    DefaultLifecycleProcessor defaultLifecycleProcessor = new DefaultLifecycleProcessor();
//    defaultLifecycleProcessor.setTimeoutPerShutdownPhase(10000);
//    return defaultLifecycleProcessor;
//  }
  public BeanPostProcessor beanPostProcessor() {
    return new InstantiationTracingBeanPostProcessor();
  }
}
