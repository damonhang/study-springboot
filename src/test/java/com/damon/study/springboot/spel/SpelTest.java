package com.damon.study.springboot.spel;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpelTest {

  @Test
  public void shouldExpressionSuccess() {
    SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE,
        this.getClass().getClassLoader());
    ExpressionParser parser = new SpelExpressionParser(config);
    Expression exp = parser.parseExpression("'Hello World'.concat('!')");
    String message = (String) exp.getValue();
    Assert.assertEquals("Hello World!", message);
    exp = parser.parseExpression("new String('hello world').toUpperCase()");
    message = exp.getValue(String.class);
    Assert.assertEquals("HELLO WORLD", message);
  }
}
