package com.mb.weblog.common.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mb.weblog.common.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
@Aspect
@Component
@Slf4j
public class ApiOperationLogAspect {

    @Pointcut("@annotation(com.mb.weblog.common.aspect.ApiOperationLog)")
    public void apiOperationLog(){}

    /**
     * 环绕
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("apiOperationLog()")
    public Object doAroud(ProceedingJoinPoint joinPoint) throws Throwable{
        try{
            long startTime = System.currentTimeMillis();

            MDC.put("traceId", UUID.randomUUID().toString());

            String className = joinPoint.getTarget().getClass().getSimpleName();
            String methodName = joinPoint.getSignature().getName();

            Object[] args = joinPoint.getArgs();
            String argsJsonStr = Arrays.stream(args).map(toJsonStr()).collect(Collectors.joining(", "));

            String description = getApiOperationLogDescription(joinPoint);

            // 打印请求相关参数
            log.info("====== 请求开始: [{}], 入参: {}, 请求类: {}, 请求方法: {} =================================== ",
                    description, argsJsonStr, className, methodName);

            // 执行切点方法
            Object result = joinPoint.proceed();

            // 执行耗时
            long executionTime = System.currentTimeMillis() - startTime;

            // 打印出参等相关信息
            log.info("====== 请求结束: [{}], 耗时: {}ms, 出参: {} =================================== ",
                    description, executionTime, JsonUtil.toJsonString(result));

            return result;

        }finally {
            MDC.clear();

        }
    }

    private String getApiOperationLogDescription(ProceedingJoinPoint joinPoint) {
        // 1. 从 ProceedingJoinPoint 获取 MethodSignature
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        // 2. 使用 MethodSignature 获取当前被注解的 Method
        Method method = signature.getMethod();

        // 3. 从 Method 中提取 LogExecution 注解
        ApiOperationLog apiOperationLog = method.getAnnotation(ApiOperationLog.class);

        // 4. 从 LogExecution 注解中获取 description 属性
        return apiOperationLog.description();
    }
    private Function<Object, String> toJsonStr() {
        return arg -> JsonUtil.toJsonString(arg);
    }
}
