package com.sy.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 用户登录AOP
 * @author chris
 */
public class LoginComponent {

    @Pointcut("execution(* com.sy.service.*Service*.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(args[0].toString());
        System.out.println("before login");
    }

}
