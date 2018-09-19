package org.springframework.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAOP {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringConfiguration.class);
        context.scan("org.springframework.aop");
        context.refresh();

        EmployeeManager manager = context.getBean(EmployeeManager.class);
        manager.getEmployeeById(1);

    }
}
