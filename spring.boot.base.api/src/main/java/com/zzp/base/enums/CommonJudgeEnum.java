package com.zzp.base.enums;

/**
 * 通用判断枚举
 * 
 * @author zzp
 * @since 2019.03.12
 *
 */
public enum CommonJudgeEnum {
	
	NO(0, "否"),
	YES(1, "是");
	
	private int id;
	
	private String name;
	
	private CommonJudgeEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static String fromId(int id){
		for(CommonJudgeEnum  e : CommonJudgeEnum.values()){
			if(e.id == id){
				return e.getName();
			}
		}
		return null;
	}

}
