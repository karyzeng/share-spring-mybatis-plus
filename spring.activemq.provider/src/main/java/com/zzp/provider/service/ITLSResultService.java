package com.zzp.provider.service;

import com.zzp.provider.entity.TLSResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzp
 * @since 2020-06-23
 */
public interface ITLSResultService extends IService<TLSResult> {

    TLSResult listSIds(String inquirerCompanyUid, String quoteSupplierTransportIdArray);

}
