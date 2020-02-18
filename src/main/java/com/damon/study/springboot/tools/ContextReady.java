package com.damon.study.springboot.tools;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ContextReady implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("context ready");
  }

  @Bean
  public ExitCodeGenerator exitCodeGenerator() {
    return () -> 42;
  }
}
