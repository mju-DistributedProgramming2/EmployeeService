package com.omnm.employee.DTO;

import com.omnm.employee.Entity.Employee;
import com.omnm.employee.enumeration.employee.Department;

public class GetEmployeeResponse {
    String employeeId;
    Department department;
    String name;
    public GetEmployeeResponse(Employee employee) {
        this.employeeId = employee.getEmployeeId();
        this.department = employee.getDepartment();
        this.name = employee.getName();
    }
}
