package com.zzp.provider.mapper;

import com.zzp.provider.entity.TLSResult;
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
public interface TLSResultMapper extends BaseMapper<TLSResult> {

    List<TLSResult> listSIds(@Param("inquirerCompanyUid") String inquirerCompanyUid, @Param("quoteSupplierTransportIdArray")String quoteSupplierTransportIdArray);

}
