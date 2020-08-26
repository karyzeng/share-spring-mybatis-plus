package com.zzp.provider.mapper;

import com.zzp.provider.entity.TQuoteLogisticsTransport;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzp
 * @since 2020-06-23
 */
public interface TQuoteLogisticsTransportMapper extends BaseMapper<TQuoteLogisticsTransport> {

    List<TQuoteLogisticsTransport> listQuoteLogisticsTransports(@Param("quoterCompanyCode") String quoterCompanyCode);

}
