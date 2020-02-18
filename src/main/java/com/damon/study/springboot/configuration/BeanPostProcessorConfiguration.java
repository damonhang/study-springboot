package com.damon.study.springboot.configuration;

import com.damon.study.springboot.bean.CommonUser;
import com.damon.study.springboot.test.core.SimpleBeanFactoryPostProcessor;
import java.util.HashSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("learn")
public class BeanPostProcessorConfiguration {

  @Bean
  public SimpleBeanFactoryPostProcessor simpleBeanFactoryPostProcessor() {
    SimpleBeanFactoryPostProcessor factoryPostProcessor = new SimpleBeanFactoryPostProcessor();
    HashSet<String> obscenties = new HashSet<>();
    obscenties.add("baozun");
    obscenties.add("weiruan");
    factoryPostProcessor.setObscenties(obscenties);
    return factoryPostProcessor;
  }

  @Bean
  public CommonUser commonUser1() {
    return new CommonUser("test", "baozun");
  }
}
