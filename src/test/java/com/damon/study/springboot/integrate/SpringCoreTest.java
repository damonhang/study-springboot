package com.damon.study.springboot.integrate;

import com.damon.study.springboot.test.annotion.SpringIntegrationTestConfiguration;
import com.damon.study.springboot.bean.user.UserBaseInfo;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringIntegrationTestConfiguration
public class SpringCoreTest {

  @Autowired
  private ApplicationContext applicationContext;

  @Test
  public void testAliasBean() {
    String[] beanNamesForType = applicationContext.getBeanNamesForType(UserBaseInfo.class);
    System.out.println(Arrays.toString(beanNamesForType));//>??根据name获取不到bean
    System.out.println(applicationContext.containsBean("userBaseInfo"));//>??根据name获取不到bean
  }
}
