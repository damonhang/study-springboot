package com.damon.study.springboot.test.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("qualifier")
public class CommonTestBean {

}
