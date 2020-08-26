package com.zzp.consumer.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzp.consumer.entity.TCoupon;
import com.zzp.consumer.mapper.TCouponMapper;
import com.zzp.consumer.service.ITCouponService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 优惠券 服务实现类
 * </p>
 *
 * @author zzp
 * @since 2019-12-03
 */
@Service
public class TCouponServiceImpl extends ServiceImpl<TCouponMapper, TCoupon> implements ITCouponService {

}
