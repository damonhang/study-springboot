package com.damon.study.springboot.configuration;

import com.damon.study.springboot.bean.CommonUser;
import com.damon.study.springboot.bean.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@Import({SpringCoreTestConfiguration.class})
public class SpringTestConfiguration {

  @Bean
  @Profile("learn")
  public CommonUser commonUser() {
    return new CommonUser("", "");
  }

  @Bean
  @Profile("product")
  public TestBean testBean() {
    return new TestBean("");
  }

}
