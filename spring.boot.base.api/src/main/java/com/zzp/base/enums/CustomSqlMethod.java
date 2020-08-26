package com.zzp.base.enums;

/**
 * @author 自定义SqlMethod
 * @Description Garyzeng
 * @since 2019.12.13
 **/
public enum CustomSqlMethod {

    LOGIC_UPDATE_ALL_COLUMN_BY_ID("updateAllColumnById", "根据ID 修改数据", "<script>\nUPDATE %s %s WHERE %s=#{%s} %s\n</script>")
    ;

    private String method;
    private String desc;
    private String sql;

    private CustomSqlMethod(String method, String desc, String sql) {
        this.method = method;
        this.desc = desc;
        this.sql = sql;
    }

    public String getMethod() {
        return method;
    }

    public String getDesc() {
        return desc;
    }

    public String getSql() {
        return sql;
    }}
