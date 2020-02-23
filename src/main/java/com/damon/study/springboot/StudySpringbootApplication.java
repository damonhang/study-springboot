package com.damon.study.springboot;

import com.damon.study.springboot.test.listener.ApplicationCoreTestListener;
import java.util.Arrays;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class StudySpringbootApplication {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder()
				.sources(StudySpringbootApplication.class)
				//.child(Application.class)
				.bannerMode(Mode.OFF)
				.listeners(new ApplicationCoreTestListener())
				.run(args);
		applicationContext.registerShutdownHook();
//		applicationContext.addBeanFactoryPostProcessor();
	}

}
