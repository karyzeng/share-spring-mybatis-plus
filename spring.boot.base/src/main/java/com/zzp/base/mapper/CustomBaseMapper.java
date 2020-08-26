package com.zzp.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

/**
 * 自定义BaseMapper
 * @author zzp
 * @since 2019.05.18
 * @param <T>
 */
public interface CustomBaseMapper<T> extends BaseMapper<T> {

    boolean updateAllColumnById(@Param(Constants.ENTITY) T entity);
}
