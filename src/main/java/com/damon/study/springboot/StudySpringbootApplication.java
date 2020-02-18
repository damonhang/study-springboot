package com.damon.study.springboot;

import com.damon.study.springboot.listener.SimpleListener;
import java.util.Arrays;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StudySpringbootApplication {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder()
				.sources(StudySpringbootApplication.class)
				//.child(Application.class)
				.bannerMode(Mode.OFF)
				.listeners(new SimpleListener())
				.run(args);
		applicationContext.registerShutdownHook();
	}

}
