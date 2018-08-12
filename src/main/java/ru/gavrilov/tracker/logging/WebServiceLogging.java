package ru.gavrilov.tracker.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Slf4j
@Component
public class WebServiceLogging {

    @Before("execution(* ru.gavrilov.tracker.services.impl.ItemRepositoryServiceImpl.*(..))")
    public void logBefore(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        log.debug("Call method: " + methodName +
                " with params " + Arrays.deepToString(args));
    }

    @AfterReturning(
            pointcut = "execution(* ru.gavrilov.tracker.services.impl.ItemRepositoryServiceImpl.*(..))",
            returning = "result")
    public void logAfter(JoinPoint jp, Object result) {
        String methodName = jp.getSignature().getName();
        String resValue = result == null ? "null" : result.toString();
        log.debug("Method \"" + methodName + "\" returned value : " + resValue);
    }

}
