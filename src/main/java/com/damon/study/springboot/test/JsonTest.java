package com.damon.study.springboot.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.util.Pair;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("learn")
public class JsonTest {
  @Autowired
  private ObjectMapper objectMapper;

  @PostConstruct
  public void toJson(){
    try {
      System.out.println(objectMapper.writeValueAsString(new Pair(1,2)));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}
