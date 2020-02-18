package com.damon.study.springboot.test.factory;

import org.springframework.beans.factory.FactoryBean;

public class FactoryClassBean implements FactoryBean<FactoryClass> {

  @Override
  public FactoryClass getObject() throws Exception {
    FactoryClass factoryClass = new FactoryClass();
    factoryClass.setUserName("FactoryClass");
    return factoryClass;
  }

  @Override
  public Class<?> getObjectType() {
    return FactoryClass.class;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }
}
