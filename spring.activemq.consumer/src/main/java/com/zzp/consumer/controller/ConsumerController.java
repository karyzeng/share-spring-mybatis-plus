package com.zzp.consumer.controller;

import com.zzp.consumer.entity.TCoupon;
import com.zzp.consumer.service.ITCouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 消息消费者controller
 * @Author Garyzeng
 * @since 2019.12.01
 **/
@Controller
@RequestMapping(value = "/consumer")
public class ConsumerController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ITCouponService couponService;

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    @ResponseBody
    public TCoupon getMessage() {
        TCoupon coupon = couponService.getById(1);
        return coupon;
    }

}
