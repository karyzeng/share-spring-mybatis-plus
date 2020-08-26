package com.zzp.consumer.msg.handlers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zzp.base.utils.SpringUtil;
import com.zzp.consumer.entity.TConsumeMessage;
import com.zzp.consumer.entity.TCoupon;
import com.zzp.consumer.service.ITConsumeMessageService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @Description 优惠券handler
 * @Author Garyzeng
 * @since 2019.12.07
 **/
public class CouponHandler extends BaseHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ITConsumeMessageService consumeMessageService = SpringUtil.getBean(ITConsumeMessageService.class);

    public boolean hasHandleByType(String type) {
        if (StringUtils.isNotBlank(type) && type.equals("Coupon")) {
            return true;
        }
        return false;
    }

    public void handlerDetail(String type, String msgId, String data, String msg) {
        TConsumeMessage consumeMessage = consumeMessageService.getConsumeMessage(msgId);
        if (consumeMessage == null) {
            // 表示还未消费过该消息
            TCoupon coupon = JSON.parseObject(data, TCoupon.class);
            logger.info(coupon.getCouponName());
            TConsumeMessage message = new TConsumeMessage();
            message.setMsgId(msgId);
            message.setType(type);
            message.setContent(msg);
            message.setCreateTime(new Date());
            consumeMessageService.save(message);
        } else {
            // 表示已消费过该消息
            logger.info("已消费过该消息，msgId：" + msgId + "，msg：" + msg);
        }

    }
}
