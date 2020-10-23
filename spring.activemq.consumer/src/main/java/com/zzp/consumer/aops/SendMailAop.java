package com.zzp.consumer.aops;

import com.zzp.consumer.entity.TConsumeMessage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description 发送邮件AOP
 * @Author karyzeng
 * @since 2020.10.23
 **/
@Aspect
@Component
public class SendMailAop {

    @Pointcut("execution(* com.zzp..service.impl.*.*(..))")
    public void pointcut() {
    }

//    @Before("pointcut()")
//    public void beginTransaction() {
//        System.out.println("before beginTransaction");
//    }
//
//    @After("pointcut()")
//    public void commit() {
//        System.out.println("after commit");
//    }
//
//    @AfterReturning("pointcut()", returning = "returnObject")
//    public void afterReturning(JoinPoint joinPoint, Object returnObject) {
//        System.out.println("afterReturning");
//    }
//
//    @AfterThrowing("pointcut()")
//    public void afterThrowing() {
//        System.out.println("afterThrowing afterThrowing  rollback");
//    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            System.out.println("around start");
            Object result = joinPoint.proceed();
            TConsumeMessage consumeMessage = (TConsumeMessage) result;
            System.out.println("around end");
            return result;
        } catch (Throwable e) {
            e.printStackTrace();
            throw e;
        } finally {
            System.out.println("around");
        }
    }

}
