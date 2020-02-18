package com.damon.study.springboot.configuration;

import com.damon.study.springboot.bean.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@Profile("learn")
@PropertySource("classpath:app.properties")
public class LearnConfiguration {

  @Autowired
  Environment env;

  @Bean
  @Qualifier("public")
  public TestBean publicInstance() {
    return new TestBean("publicInstance");
  }


  @Bean
  public TestBean testBean() {
    TestBean testBean = new TestBean("");
    testBean.setName(env.getProperty("testbean.name"));
    return testBean;
  }
}
