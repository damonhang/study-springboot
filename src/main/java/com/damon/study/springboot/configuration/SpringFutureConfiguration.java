package com.damon.study.springboot.configuration;

import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("learn")
public class SpringFutureConfiguration {
  @Bean
  public CustomAutowireConfigurer customAutowireConfigurer(){
    CustomAutowireConfigurer autowireConfigurer = new CustomAutowireConfigurer();
    return autowireConfigurer;
  }
}
