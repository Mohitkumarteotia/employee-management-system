package com.service.employee.service;

import com.service.employee.pojos.request.EmployeeRequest;
import com.service.employee.pojos.response.EmployeeResponse;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeRequest employeeRequest);
}
