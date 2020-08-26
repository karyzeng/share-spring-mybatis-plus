package com.zzp.provider.timing.tasks;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzp.base.enums.CommonJudgeEnum;
import com.zzp.provider.entity.TSendMessage;
import com.zzp.provider.service.ITSendMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description 发送消息到mq的定时任务
 * @author Garyzeng
 * @since 2019.12.13
 **/
@Component
public class SendMessageTask {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ITSendMessageService sendMessageService;

    @Scheduled(cron = "0 0/2 * * * *")
    public void run() {
        logger.info("发送消息到mq任务开始");

        QueryWrapper<TSendMessage> queryWrapper = new QueryWrapper<TSendMessage>();
        queryWrapper.eq("send_flag", CommonJudgeEnum.NO.getId());
        queryWrapper.orderByAsc("create_time");
        List<TSendMessage> sendMessages = sendMessageService.list(queryWrapper);
        if (sendMessages != null && sendMessages.size() > 0) {
            for (int i = 0; i < sendMessages.size(); i++) {
                TSendMessage sendMessage = sendMessages.get(i);
                try {
                    sendMessageService.sendMqAndUpdateSendFlag(sendMessage);
                    logger.info("发送消息到mq任务，msgId：" + sendMessage.getMsgId() + "，sendMessage：" + JSON.toJSONString(sendMessage) + "，发送成功");
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.info("发送消息到mq任务，msgId：" + sendMessage.getMsgId() + "，sendMessage：" + JSON.toJSONString(sendMessage) + "，发送失败，异常信息：" + e.getMessage());
                }

            }
        } else {
            logger.info("发送消息到mq任务，sendMessages列表为空");
        }

        logger.info("发送消息到mq任务结束");
    }

}
