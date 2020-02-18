package com.damon.study.springboot;

import org.springframework.test.context.ActiveProfilesResolver;

public class OperatingSystemActiveProfilesResolver implements ActiveProfilesResolver {

  @Override
  public String[] resolve(Class<?> testClass) {
    String profile = "learn";
    return new String[]{profile};
  }
}
