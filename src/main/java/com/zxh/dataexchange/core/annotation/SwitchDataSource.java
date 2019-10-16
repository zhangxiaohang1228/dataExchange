package com.zxh.dataexchange.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: zxh
 * @Date: 2019-10-16 14:38
 * @Description: 注解，放在方法上用来动态切换数据源
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SwitchDataSource {
    String dataSourceName() default "";
}
