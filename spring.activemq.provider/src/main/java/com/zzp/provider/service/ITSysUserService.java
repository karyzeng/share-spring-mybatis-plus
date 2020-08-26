package com.zzp.provider.service;

import com.zzp.provider.entity.TSysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzp
 * @since 2019-12-03
 */
public interface ITSysUserService extends IService<TSysUser> {

    /**
     * 根据id用户信息
     */
    void updateAllColumnById(TSysUser entity);

}
