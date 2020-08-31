package com.zzp.consumer.events;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @Description 测试spring容器事件
 * @Author karyzeng
 * @since 2020.08.31
 **/
public class TestEvent extends ApplicationContextEvent {

    private String eventContent;

    public TestEvent(ApplicationContext source, String content) {
        super(source);
        this.eventContent = content;
    }

    public String getEventContent() {
        return eventContent;
    }
}
