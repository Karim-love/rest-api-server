package com.karim.restApiServer.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * AOP class 모음
 */
@Aspect
@Component
public class TimeTraceAop {

    /**
     * 메소드 시간 측정 APO 메소드
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    // 어디에 적용할지 범위 타겟팅
    @Around("execution(* com.karim.restApiServer..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println( "START : " + joinPoint.toString() );

        try {
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println( "END : " + joinPoint.toString() + " " + timeMs + "ms" );
        }
    }
}
