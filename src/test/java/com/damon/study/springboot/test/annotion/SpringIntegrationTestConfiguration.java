package com.damon.study.springboot.test.annotion;

import com.damon.study.springboot.OperatingSystemActiveProfilesResolver;
import com.damon.study.springboot.configuration.SpringTestConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes = SpringTestConfiguration.class)
@RunWith(SpringRunner.class)
@WebAppConfiguration
@ActiveProfiles(resolver = OperatingSystemActiveProfilesResolver.class)
@TestPropertySource(locations = "classpath:test.properties", properties = {"timezone = GMT", "port: 4242"})
public @interface SpringIntegrationTestConfiguration {

}
