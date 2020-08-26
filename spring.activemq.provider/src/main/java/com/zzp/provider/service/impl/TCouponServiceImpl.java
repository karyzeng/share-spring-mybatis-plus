package com.zzp.provider.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zzp.provider.entity.TCoupon;
import com.zzp.provider.mapper.TCouponMapper;
import com.zzp.provider.service.ITCouponService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 优惠券 服务实现类
 * </p>
 *
 * @author zzp
 * @since 2019-12-03
 */
@DS("slave1")
@Service
public class TCouponServiceImpl extends ServiceImpl<TCouponMapper, TCoupon> implements ITCouponService {

}
