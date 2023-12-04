package com.omnm.employee.DTO;

import com.omnm.employee.enumeration.employee.Department;

public class GetEmployeeRequest {
    String employeeId;
    Department department;
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
