package com.zzp.provider.service;

import com.zzp.provider.entity.TQuoteLogisticsTransport;
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
public interface ITQuoteLogisticsTransportService extends IService<TQuoteLogisticsTransport> {

    List<TQuoteLogisticsTransport> listQuoteLogisticsTransports(String quoterCompanyCode);

    Integer linkLogisticsAndSupplier(String companyUid);

}
