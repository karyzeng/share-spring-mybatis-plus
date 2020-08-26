package com.zzp.provider.service;

import com.zzp.base.mq.msg.vo.Message;
import com.zzp.provider.entity.TSendMessage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 发送的消息 服务类
 * </p>
 *
 * @author zzp
 * @since 2019-12-12
 */
public interface ITSendMessageService extends IService<TSendMessage> {

    /**
     * 保存消息到本地，并且发送消息到mq
     * @param message
     */
    void saveMessageAndSendMq(Message message);

    /**
     * 根据msgId来修改消息发送状态
     * @param msgId
     */
    void updateSendFlag(String msgId, Integer sendFlag);

    void sendMqAndUpdateSendFlag(TSendMessage sendMessage);

}
