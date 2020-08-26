package com.zzp.provider.service.impl;

import com.zzp.provider.entity.TLSResult;
import com.zzp.provider.mapper.TLSResultMapper;
import com.zzp.provider.service.ITLSResultService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class TLSResultServiceImpl extends ServiceImpl<TLSResultMapper, TLSResult> implements ITLSResultService {

    @Autowired
    private TLSResultMapper lsResultMapper;

    @Override
    public TLSResult listSIds(String inquirerCompanyUid, String quoteSupplierTransportIdArray) {
        List<TLSResult> lsResults = lsResultMapper.listSIds(inquirerCompanyUid, quoteSupplierTransportIdArray);
        if (CollectionUtils.isEmpty(lsResults)) {
            return null;
        }
        return lsResults.get(0);
    }
}
