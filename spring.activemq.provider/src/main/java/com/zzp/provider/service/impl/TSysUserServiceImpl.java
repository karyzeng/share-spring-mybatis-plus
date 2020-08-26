package com.zzp.provider.service.impl;

import com.zzp.provider.entity.TSysUser;
import com.zzp.provider.mapper.TSysUserMapper;
import com.zzp.provider.service.ITSysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzp
 * @since 2019-12-03
 */
@Service
public class TSysUserServiceImpl extends ServiceImpl<TSysUserMapper, TSysUser> implements ITSysUserService {

    @Autowired
    private TSysUserMapper sysUserMapper;

    @Override
    public void updateAllColumnById(TSysUser entity) {
        sysUserMapper.updateAllColumnById(entity);
    }
}
