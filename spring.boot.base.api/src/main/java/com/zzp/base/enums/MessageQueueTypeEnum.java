package com.zzp.base.enums;

/**
 * @Description 消息队列类型枚举
 * @Author Garyzeng
 * @since 2019.12.18
 **/
public enum MessageQueueTypeEnum {

    QUEUE("queue", "点对点"),
    TOPIC("topic", "订阅/发布");

    private String name;

    private String description;

    private MessageQueueTypeEnum(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
