package ru.clevertec.performancemonitoring.aop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import ru.clevertec.performancemonitoring.configuration.PerformanceMonitoringProperties;

@Slf4j
@Aspect
@RequiredArgsConstructor
public class PerformanceMonitoringAspect {

    public static final String METHOD_EXECUTED_IN_MS = "Method {} executed in {} ms";

    private final PerformanceMonitoringProperties properties;

    @Pointcut("@annotation(ru.clevertec.performancemonitoring.annotation.PerformanceMonitoring)")
    public void performanceMonitoringMethods() {

    }

    @Around("performanceMonitoringMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;

        if (executionTime >= properties.getMinTime()) {
            log.info(METHOD_EXECUTED_IN_MS, joinPoint.getSignature(), executionTime);
        }

        return result;
    }

}
