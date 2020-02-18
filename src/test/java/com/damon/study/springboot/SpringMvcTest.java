package com.damon.study.springboot;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

@SpringJUnitWebConfig(locations = "test-servlet-context.xml")
public class SpringMvcTest {
  private MockMvc mockMvc;

  void setup(WebApplicationContext wac) {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

//  @Test
//  void getAccount() throws Exception {
//    RestTemplate restTemplate = new RestTemplate();
//    restTemplate.
//    this.mockMvc.perform(get("/accounts/1")
//        .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
//        .andExpect(status().isOk())
//        .andExpect(content().contentType("application/json"))
//        .andExpect(jsonPath("$.name").value("Lee"));
//  }
}
