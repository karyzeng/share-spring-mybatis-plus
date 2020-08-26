package com.zzp.base.mq.msg.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description MQ传输对象
 * @Author Garyzeng
 * @since 2019.12.07
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Message<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String msgId;

    private String type;

    /**
     * 消息来源系统
     */
    private String sourceSystem;

    /**
     * 消息类型
     */
    private String queueType;

    /**
     * 消息队列名称
     */
    private String queueName;

    private T data;

}
