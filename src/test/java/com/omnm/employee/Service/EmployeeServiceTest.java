package com.omnm.employee.Service;

import com.omnm.employee.DAO.EmployeeDAO;
import com.omnm.employee.Entity.Employee;
import com.omnm.employee.enumeration.Department;
import com.omnm.employee.enumeration.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Mock
    private EmployeeDAO employeeDAO;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRegisterEmployee_Success() {
        Employee employee = new Employee(1, "1234", "1234", Department.UW, "ank", "ankemail", 1111111111, Rank.SeniorStaff);

        when(employeeDAO.findEmployeeByEmployeeId(employee.getEmployeeId())).thenReturn(null);

        ResponseEntity<Boolean> response = employeeService.registerEmployee(employee);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(true, response.getBody());

        verify(employeeDAO, times(1)).findEmployeeByEmployeeId(employee.getEmployeeId());
        verify(employeeDAO, times(1)).createEmployee(employee);
        verifyNoMoreInteractions(employeeDAO);
        System.out.println("testRegisterEmployee_Success 테스트 성공");
    }

    @Test
    void testRegisterEmployee_Failure() {
        Employee existingEmployee = new Employee(1, "1234", "1234", Department.UW, "ank", "ankemail", 1111111111, Rank.SeniorStaff);

        when(employeeDAO.findEmployeeByEmployeeId(existingEmployee.getEmployeeId())).thenReturn(existingEmployee);

        ResponseEntity<Boolean> response = employeeService.registerEmployee(existingEmployee);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(false, response.getBody());

        verify(employeeDAO, times(1)).findEmployeeByEmployeeId(existingEmployee.getEmployeeId());
        verifyNoMoreInteractions(employeeDAO);
        System.out.println("testRegisterEmployee_Failure 테스트 성공");
    }

    @Test
    void testLoginEmployee_Success() {
        String employeeId = "1234";
        String password = "1234";
        Employee employee = new Employee(1, "1234", "1234", Department.UW, "ank", "ankemail", 1111111111, Rank.SeniorStaff);

        when(employeeDAO.findEmployeeByEmployeeId(employeeId)).thenReturn(employee);

        ResponseEntity<Employee> response = employeeService.loginEmployee(employeeId, password);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employee, response.getBody());

        verify(employeeDAO, times(1)).findEmployeeByEmployeeId(employeeId);
        verifyNoMoreInteractions(employeeDAO);
        System.out.println("testLoginEmployee_Success 테스트 성공");
    }
}

