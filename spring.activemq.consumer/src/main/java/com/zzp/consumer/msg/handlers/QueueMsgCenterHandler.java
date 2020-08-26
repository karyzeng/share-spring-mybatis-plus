package com.zzp.consumer.msg.handlers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description 消息队列处理handler
 * @Author Garyzeng
 * @since 2019.12.03
 **/
@Component
public class QueueMsgCenterHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @JmsListener(destination = "test_queue", containerFactory = "jmsListenerContainerQueue")
    public void receiveMessage(String message) {
        logger.info("从mq的test_queue队列中接收到消息：" + message);
        JSONObject jsonObject = JSON.parseObject(message);
        String type = jsonObject.getString("type");
        String handlerName = type + "Handler";
        Class handlerClass = null;
        try {
            handlerClass = Class.forName(this.getClass().getPackage().getName() + "." + handlerName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (handlerClass != null) {
            try {
                handle(handlerClass, message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            logger.error("找不到" + handlerName);
        }
    }

    private void handle(Class handler, String message) throws Exception{
        Method method = handler.getMethod("handler", String.class);
        method.invoke(handler.newInstance(), message);
    }

}
