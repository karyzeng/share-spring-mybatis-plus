package com.zzp.consumer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzp.consumer.entity.TConsumeMessage;
import com.zzp.consumer.mapper.TConsumeMessageMapper;
import com.zzp.consumer.service.ITConsumeMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 已经消费的消息 服务实现类
 * </p>
 *
 * @author zzp
 * @since 2019-12-08
 */
@Service
public class TConsumeMessageServiceImpl extends ServiceImpl<TConsumeMessageMapper, TConsumeMessage> implements ITConsumeMessageService {

    public TConsumeMessage getConsumeMessage(String msgId) {
        QueryWrapper<TConsumeMessage> queryWrapper = new QueryWrapper<TConsumeMessage>();
        queryWrapper.eq("msg_id", msgId);
        return this.getOne(queryWrapper);
    }
}
