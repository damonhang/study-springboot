package com.damon.study.springboot;

import com.damon.study.springboot.test.annotion.SpringIntegrationTestConfiguration;
import com.damon.study.springboot.bean.CommonUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * ApplicationContext 是缓存的，相同配置的测试会使用同一个context
 */
@RunWith(SpringRunner.class)
@SpringIntegrationTestConfiguration
//@Sql("/test-schema.sql")
//@ContextHierarchy({ 指定层次结构
//    @ContextConfiguration("/parent-config.xml"),
//    @ContextConfiguration("/child-config.xml")
//})
@TestExecutionListeners({ServletTestExecutionListener.class,
    DirtiesContextBeforeModesTestExecutionListener.class, DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class,
    SqlScriptsTestExecutionListener.class})//by default
public class SpringIntegrationTest {

  @Autowired
  private ApplicationContext applicationContext;

  @Autowired
  WebApplicationContext wac; // cached

  @Autowired
  MockServletContext servletContext; // cached

  @Autowired
  MockHttpSession session;

  @Autowired
  MockHttpServletRequest request;

  @Autowired
  MockHttpServletResponse response;

  @Autowired
  ServletWebRequest webRequest;

//  @Autowired
//  SimpleUserService userService;


  @Test
  public void testConfiguration() {
    Assert.assertNotNull(applicationContext.getBean(CommonUser.class));
  }

  @Test
  public void testActiveProfiles() {
    Assert.assertFalse(applicationContext.containsBean("testBean"));
  }

  @Test
  public void testPropertySource() {
    Environment environment = applicationContext.getEnvironment();
    Assert.assertEquals(environment.getProperty("timezone"), "GMT");
    Assert.assertEquals(environment.getProperty("testPropertyKey"), "testPropertyValue");
  }

  @Test
  public void testRequestScope() {
    request.setParameter("user", "enigma");
    request.setParameter("pswd", "$pr!ng");
    // assert results
  }



//  @Test
//  public void databaseTest {
//    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
//    populator.addScripts(
//        new ClassPathResource("test-schema.sql"),
//        new ClassPathResource("test-data.sql"));
//    populator.setSeparator("@@");
//    populator.execute(this.dataSource);
//    // execute code that uses the test schema and data
//  }
}
