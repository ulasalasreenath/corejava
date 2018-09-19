package org.springframework.aop;

import org.springframework.stereotype.Component;

@Component
public class EmployeeManager {

    public String getEmployeeById(Integer employeeId) {

        System.out.println("Method getEmployeeById() is called");
        return "Employee1";

    }
}
