package com.damon.study.springboot.service.test;


import com.damon.study.springboot.bean.CommonUser;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class SpringUnitTestServiceTest {

  public static final String NEW_NAME = "newName";

  @Test
  public void testReflectionTestUtils() {
    CommonUser commonUser = new CommonUser("damon", "123456");
    ReflectionTestUtils.setField(commonUser, "userName", "newName");
    Assert.assertEquals(NEW_NAME,commonUser.getUserName());
  }
}