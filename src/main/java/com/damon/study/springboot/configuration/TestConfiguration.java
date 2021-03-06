package com.damon.study.springboot.configuration;

import com.damon.study.springboot.test.factory.FactoryClassBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("learn")
public class TestConfiguration {
  @Bean
  public FactoryClassBean factoryClassBean(){
    return new FactoryClassBean();
  }
}
