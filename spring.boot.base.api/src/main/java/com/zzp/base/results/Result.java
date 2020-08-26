package com.zzp.base.results;


import com.zzp.base.enums.ResultEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * API Response
 * @author Garyzeng
 * @since 2019.12.27
 * {
 *    msg: "查询成功",
 *    ok: true,
 *    status: 10001,
 *    data: dataJson
 * }
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Result<T> extends BaseResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3446563173827752325L;
	/**
     * 数据集
     */
	private T data;
	
	public Result() {};
	
	public Result(String msg, Boolean ok) {
		this.msg = msg;
		this.ok = ok;
	}

	public Result(String msg, Boolean ok, T data) {
		this.msg = msg;
		this.ok = ok;
		this.data = data;
	}
	
	public Result(String msg, Boolean ok, Integer status, T data) {
		this.msg = msg;
		this.ok = ok;
		this.status = status;
		this.data = data;
	}
	
	public static <T> Result<T> ok(T data) {
        return restResult(data, ResultEnum.SUCCESSED.getCode(), "", true);
    }
	
	public static <T> Result<T> ok(String msg) {
        return restResult(null, ResultEnum.SUCCESSED.getCode(), msg, true);
    }
	
	public static <T> Result<T> ok(String msg, T data) {
        return restResult(data, ResultEnum.SUCCESSED.getCode(), msg, true);
    }

    public static <T> Result<T> failed(String msg) {
        return restResult(null, ResultEnum.FAILED.getCode(), msg, false);
    }
    
    public static <T> Result<T> failed(String msg, T data) {
        return restResult(data, ResultEnum.FAILED.getCode(), msg, false);
    }

    private static <T> Result<T> restResult(T data, Integer status, String msg, Boolean ok) {
    	Result<T> apiResult = new Result<>();
        apiResult.setStatus(status);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        apiResult.setOk(ok);
        
        return apiResult;
    }
}
