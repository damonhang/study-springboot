package com.damon.study.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

  @RequestMapping("/index")
  String home() {
    return "Hello World!";
  }
}
