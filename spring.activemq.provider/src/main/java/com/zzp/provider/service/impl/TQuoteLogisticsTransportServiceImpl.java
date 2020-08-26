package com.zzp.provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzp.provider.entity.TLSResult;
import com.zzp.provider.entity.TQuoteLogisticsTransport;
import com.zzp.provider.mapper.TQuoteLogisticsTransportMapper;
import com.zzp.provider.service.ITLSResultService;
import com.zzp.provider.service.ITQuoteLogisticsTransportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzp
 * @since 2020-06-23
 */
@Service
public class TQuoteLogisticsTransportServiceImpl extends ServiceImpl<TQuoteLogisticsTransportMapper, TQuoteLogisticsTransport> implements ITQuoteLogisticsTransportService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TQuoteLogisticsTransportMapper quoteLogisticsTransportMapper;

    @Autowired
    private ITLSResultService lsResultService;

    @Override
    public List<TQuoteLogisticsTransport> listQuoteLogisticsTransports(String quoterCompanyCode) {
        return quoteLogisticsTransportMapper.listQuoteLogisticsTransports(quoterCompanyCode);
    }

    @Override
    public Integer linkLogisticsAndSupplier(String companyUid) {
        List<TQuoteLogisticsTransport> logisticsTransports = this.listQuoteLogisticsTransports(companyUid);
        if (CollectionUtils.isEmpty(logisticsTransports)) {
            return null;
        }

        List<TLSResult> tlsResults = new ArrayList<TLSResult>();
        int total = 0;
        for (int i = 0; i < logisticsTransports.size(); i++) {
            TQuoteLogisticsTransport logisticsTransport = logisticsTransports.get(i);
            TLSResult tlsResult = lsResultService.listSIds(companyUid, logisticsTransport.getQuoteSupplierTransportIdArray());
            total = (i + 1);
            logger.info("第{}条记录，内容为：{}", total, JSON.toJSONString(tlsResult));
            if (tlsResult != null) {
                tlsResult.setLId(logisticsTransport.getId());
                tlsResults.add(tlsResult);
            }
        }
        lsResultService.saveBatch(tlsResults);
        return total;
    }
}
