package com.zzp.base.results;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description result基类
 * @Author Garyzeng
 * @since 2019.12.27
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public abstract class BaseResult implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 提示信息
     */
    protected String msg;
    /**
     * 请求成功(true)/失败(false)
     */
    protected Boolean ok = false;
    /**
     * 响应状态
     */
    protected Integer status;

}
