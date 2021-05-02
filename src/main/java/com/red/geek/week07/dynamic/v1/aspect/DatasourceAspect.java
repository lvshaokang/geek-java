package com.red.geek.week07.dynamic.v1.aspect;

import com.red.geek.week07.dynamic.v1.config.DatasourceManager;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 数据源切换切面
 *
 * @author red
 * @class_name DatasourceAspect
 * @date 2021-05-02
 */
@Aspect
@Component
@Slf4j
public class DatasourceAspect {

    @Autowired
    DatasourceManager datasourceManager;

    @Pointcut("@annotation(com.red.geek.week07.dynamic.v1.annotation.Datasource)")
    public void datasource() {};

    @Around("datasource()")
    public Object setDatasource(ProceedingJoinPoint point) {
        Object[] args = point.getArgs();
        args[0] = datasourceManager.getSlaveDatasource();
        try {
            return point.proceed(args);
        } catch (Throwable e) {
            log.warn("切换slave数据源异常, 异常信息: {}", e.getMessage(), e);
        }
        return null;
    }

}
