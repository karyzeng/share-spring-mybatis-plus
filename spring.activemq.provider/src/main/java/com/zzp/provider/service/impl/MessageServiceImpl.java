package com.zzp.provider.service.impl;

import com.zzp.provider.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @Description mq发送service接口实现类
 * @Author Garyzeng
 * @since 2019.12.03
 **/
@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void sendMessage(String destinationName, String msg) {
        jmsMessagingTemplate.convertAndSend(destinationName, msg);
    }

    @Override
    public void sendMessage(String msg) {
        this.sendMessage("test_queue", msg);
    }
}
