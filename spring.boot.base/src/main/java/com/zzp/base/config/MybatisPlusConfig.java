package com.zzp.base.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.zzp.base.method.CustomSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlusConfig
 * @author zzp
 * @since 2019.12.12
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 自定义SQL注入器
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new CustomSqlInjector();
    }
    
}
