package com.abhishek.masterslave.config.db.datasourceutil;


import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Aspect
@Component
@RequiredArgsConstructor
public class DataSourceAspect {

    @Pointcut("@annotation(com.abhishek.masterslave.config.db.datasourceutil.DataSourceAnnotation)")
    public void filterAnnotation() {
    }

    @Around(value = "filterAnnotation()")
    public Object dataSourcePoint(ProceedingJoinPoint call) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) call.getSignature();
        DataSourceAnnotation annotation = methodSignature.getMethod().getAnnotation(DataSourceAnnotation.class);
        DataSourceType dataSourceType = annotation.value();
        DataSourceContextHolder.setDataSourceType(dataSourceType);
        return call.proceed();
    }
}
