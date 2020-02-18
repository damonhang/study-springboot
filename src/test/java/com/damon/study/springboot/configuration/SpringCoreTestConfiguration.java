package com.damon.study.springboot.configuration;

import com.damon.study.springboot.bean.user.UserBaseInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCoreTestConfiguration {

  @Bean({"userBaseInfo,userBaseInfoAlias"})
  @Qualifier("userBaseInfo")
  public UserBaseInfo userBaseInfo() {
    return new UserBaseInfo();
  }
}
