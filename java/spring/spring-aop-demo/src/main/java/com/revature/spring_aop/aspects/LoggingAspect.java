package com.revature.spring_aop.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LogManager.getLogger();

    @Before("within(com.revature.spring_aop..*)")
    public void logMethodStart(JoinPoint jp) {
        String methodSig = jp.getTarget().getClass().toString() + "." + jp.getSignature().getName();
        String argStr = Arrays.toString(jp.getArgs());
        logger.info("{} invoked at {}", methodSig, LocalDateTime.now());
        logger.info("Input arguments: {}", argStr);
    }

}
