package com.zzp.base.mq.msg.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description 确认业务vo
 * @Author Garyzeng
 * @since 2019.12.28
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ConfirmBusiness implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 消息id
     */
    private String msgId;

    /**
     * 消息内容
     */
    private String msgContent;

    /**
     * 业务是否成功
     */
    private Boolean businessSuccess;

    public ConfirmBusiness() {

    }

    public ConfirmBusiness(String msgId, String msgContent, Boolean businessSuccess) {
        this.msgId = msgId;
        this.msgContent = msgContent;
        this.businessSuccess = businessSuccess;
    }

}
