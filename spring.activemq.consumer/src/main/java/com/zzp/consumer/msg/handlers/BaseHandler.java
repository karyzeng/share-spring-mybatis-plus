package com.zzp.consumer.msg.handlers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description handler接口
 * @Author Garyzeng
 * @since 2019.12.07
 **/
public abstract class BaseHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 判断是否有能力处理该消息
     * @param msg 消息字符串
     * @return
     */
    public boolean hasHandle(String msg) {
        if (StringUtils.isBlank(msg)) {
            throw new ApiException("msg消息为空，BaseHandler无法判断是否有能力处理该消息");
        }
        JSONObject msgJson = JSON.parseObject(msg);
        String type = msgJson.getString("type");
        return hasHandleByType(type);
    }

    /**
     * 处理消息
     * @param msg 消息字符串
     */
    public void handler(String msg) {
        if (StringUtils.isBlank(msg)) {
            throw new ApiException("msg消息为空，BaseHandler无法处理该消息");
        }
        JSONObject msgJson = JSON.parseObject(msg);
        String type = msgJson.getString("type");
        String msgId = msgJson.getString("msgId");
        JSONObject dataJson = msgJson.getJSONObject("data");
        handlerDetail(type, msgId, dataJson.toJSONString(), msg);
    }

    protected abstract boolean hasHandleByType(String type);

    protected abstract void handlerDetail(String type, String msgId, String data, String msg);

}
