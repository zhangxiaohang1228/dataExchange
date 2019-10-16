package com.zxh.dataexchange.core.aop;

import com.zxh.dataexchange.core.annotation.SwitchDataSource;
import com.zxh.dataexchange.core.commons.DataSourceNames;
import com.zxh.dataexchange.core.commons.DynamicDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Auther: zxh
 * @Date: 2019-10-16 15:39
 * @Description: 切面用来动态切换数据源
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    //切点  方法使用此注解将执行切面
    @Pointcut("@annotation(com.zxh.dataexchange.core.annotation.SwitchDataSource)")
    public void dataSourcePointCut() {

    }

    //前置
    @Before("dataSourcePointCut()")
    public void doBefore(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SwitchDataSource annotation = method.getAnnotation(SwitchDataSource.class);
        if(annotation == null){
            DynamicDataSource.setDataSource(DataSourceNames.DEFAULT);
        }else{
            DynamicDataSource.setDataSource(DataSourceNames.OTHER);
        }
    }

    //返回通知
    @AfterReturning("dataSourcePointCut()")
    public void after(){
        DynamicDataSource.clearDataSource();
    }

}
