package com.damon.study.springboot.configuration;

import com.damon.study.springboot.test.bean.AspectTestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("learn")
public class AspectConfiguration {

  @Bean
  public AspectTestBean aspectTestBean() {
    return new AspectTestBean();
  }
}
