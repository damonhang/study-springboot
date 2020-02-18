package com.damon.study.springboot.test.core;

import java.util.Set;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

public class SimpleBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  private Set<String> obscenties;

  public void setObscenties(Set<String> obscenties) {
    this.obscenties = obscenties;
  }

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
    for (String definitionName : beanDefinitionNames) {
      BeanDefinition beanDefinition = beanFactory.getBeanDefinition(definitionName);
      StringValueResolver stringValueResolver = strVal -> {
        if (isObscene(strVal)) {
          return "******";
        }
        return strVal;
      };
      BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(stringValueResolver);
      visitor.visitBeanDefinition(beanDefinition);
    }
  }

  private boolean isObscene(String value) {
    return obscenties.contains(value);
  }
}
