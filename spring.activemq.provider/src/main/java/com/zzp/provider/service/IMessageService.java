package com.zzp.provider.service;

/**
 * @Description mq发送service接口
 * @Author Garyzeng
 * @since 2019.12.03
 **/
public interface IMessageService {

    void sendMessage(String destinationName, String msg);

    void sendMessage(String msg);

}
