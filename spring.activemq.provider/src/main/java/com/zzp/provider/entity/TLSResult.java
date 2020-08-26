package com.zzp.provider.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzp
 * @since 2020-06-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TLSResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 物流报价表头id
     */
    private Integer lId;

    /**
     * 供应商报价表头id列表
     */
    private String sIds;


}
