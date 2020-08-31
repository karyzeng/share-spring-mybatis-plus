package com.zzp.consumer.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Description 测试事件监听器
 * @Author karyzeng
 * @since 2020.08.31
 **/
@Component
public class TestListener implements ApplicationListener<TestEvent> {

    @Override
    public void onApplicationEvent(TestEvent event) {
        System.out.println("监听到事件：" + event.getEventContent());
    }
}
