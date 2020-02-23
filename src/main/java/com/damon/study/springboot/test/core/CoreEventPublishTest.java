package com.damon.study.springboot.test.core;

import javax.annotation.PostConstruct;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class CoreEventPublishTest implements ApplicationEventPublisherAware {

  private ApplicationEventPublisher publisher;

  public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
    this.publisher = publisher;
  }

  @PostConstruct
  public void initAndPublishEvent() {
    publisher.publishEvent(new BlackListEvent(this));
  }

  public static final class BlackListEvent extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public BlackListEvent(Object source) {
      super(source);
    }
  }
}
