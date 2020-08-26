package com.zzp.base.method;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zzp.base.enums.CustomSqlMethod;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @Description 根据id更新所有字段方法
 * @Author zzp
 * @since 2019.05.15
 **/
public class UpdateAllColumnById extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(final Class<?> mapperClass, final Class<?> modelClass, final TableInfo tableInfo) {
        final CustomSqlMethod sqlMethod = CustomSqlMethod.LOGIC_UPDATE_ALL_COLUMN_BY_ID;

        // 反射修改fieldFill值为update
        final List<TableFieldInfo> fieldList = tableInfo.getFieldList();
        for (final TableFieldInfo tableFieldInfo : fieldList) {
            final Class<? extends TableFieldInfo> aClass = tableFieldInfo.getClass();
            try {
                final Field fieldFill = aClass.getDeclaredField("fieldFill");
                fieldFill.setAccessible(true);
                fieldFill.set(tableFieldInfo, FieldFill.UPDATE);
            } catch (final NoSuchFieldException e) {
                e.printStackTrace();
            } catch (final IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        final String sql = String.format(sqlMethod.getSql(), tableInfo.getTableName(),
                this.sqlSet(false, false, tableInfo, false, null, Constants.ENTITY_DOT),
                tableInfo.getKeyColumn(), Constants.ENTITY_DOT + tableInfo.getKeyProperty(),
                new StringBuilder("<if test=\"et instanceof java.util.Map\">")
                        .append("<if test=\"et.MP_OPTLOCK_VERSION_ORIGINAL!=null\">")
                        .append(" AND ${et.MP_OPTLOCK_VERSION_COLUMN}=#{et.MP_OPTLOCK_VERSION_ORIGINAL}")
                        .append("</if></if>"));
        final SqlSource sqlSource = this.languageDriver.createSqlSource(this.configuration, sql, modelClass);
        return this.addUpdateMappedStatement(mapperClass, modelClass, sqlMethod.getMethod(), sqlSource);
    }
}
