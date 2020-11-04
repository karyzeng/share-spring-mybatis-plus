package com.zzp.provider.service.impl;

import com.zzp.provider.entity.TSendMessage;
import com.zzp.provider.entity.TSysUser;
import com.zzp.provider.service.IMessageService;
import com.zzp.provider.service.ITSendMessageService;
import com.zzp.provider.service.ITSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description mq发送service接口实现类
 * @Author Garyzeng
 * @since 2019.12.03
 **/
@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private ITSysUserService sysUserService;

    @Autowired
    private ITSendMessageService sendMessageService;

    @Override
    public void sendMessage(String destinationName, String msg) {
        jmsMessagingTemplate.convertAndSend(destinationName, msg);
    }

    @Override
    public void sendMessage(String msg) {
        this.sendMessage("test_queue", msg);
    }

    @Override
    @Transactional
    public void testTransactional() {
        TSysUser sysUser = new TSysUser();
        sysUser.setUserName("阿尼君");
        sysUser.setAge(18);
        sysUserService.saveSysUser(sysUser);

        TSendMessage sendMessage = new TSendMessage();
        sendMessage.setContent("测试发送消息");
        try {
            sendMessageService.saveSendMessage(sendMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
