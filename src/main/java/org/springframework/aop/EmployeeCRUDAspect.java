package org.springframework.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeCRUDAspect {

    @Before("execution(* org.springframework.aop.EmployeeManager.getEmployeeById(..))")
    public void logBeforeV1(JoinPoint joinPoint) {

        System.out.println("Employee CRUD Aspect.logBeforeV1() : " + joinPoint.getSignature().getName());

    }

}
