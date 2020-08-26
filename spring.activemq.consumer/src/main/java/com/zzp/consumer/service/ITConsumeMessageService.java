package com.zzp.consumer.service;

import com.zzp.consumer.entity.TConsumeMessage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 已经消费的消息 服务类
 * </p>
 *
 * @author zzp
 * @since 2019-12-08
 */
public interface ITConsumeMessageService extends IService<TConsumeMessage> {

    /**
     * 根据消息id来查找消息
     * @param msgId 消息id
     * @return TConsumeMessage
     */
    TConsumeMessage getConsumeMessage(String msgId);

}
