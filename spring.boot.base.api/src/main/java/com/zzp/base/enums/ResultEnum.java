package com.zzp.base.enums;

/**
 * API Response枚举
 * @author Garyzeng
 * @since 2019.12.27
 */
public enum ResultEnum {

	SUCCESSED(0, "成功"), FAILED(-1, "失败");

	private final int code;
	private final String name;	
	
	private ResultEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
}
