package com.damon.study.springboot.configuration;

import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringFutureConfiguration {
  @Bean
  public CustomAutowireConfigurer customAutowireConfigurer(){
    CustomAutowireConfigurer autowireConfigurer = new CustomAutowireConfigurer();
    return autowireConfigurer;
  }
}
