package com.service.employee.service.impl;

import com.service.employee.entity.Employee;
import com.service.employee.pojos.request.EmployeeRequest;
import com.service.employee.pojos.response.EmployeeResponse;
import com.service.employee.repository.EmployeeRepository;
import com.service.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = persistEmployeeDetails(employeeRequest);
        return mapToResponse(employee);
    }

    private Employee persistEmployeeDetails(EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .name(employeeRequest.getName())
                .department(employeeRequest.getDepartment())
                .jobTitle(employeeRequest.getJobTitle())
                .salary(employeeRequest.getSalary())
                .build();
        return employeeRepository.save(employee);
    }

    private EmployeeResponse mapToResponse(Employee employee) {
        return EmployeeResponse.builder()
                .name(employee.getName())
                .department(employee.getDepartment())
                .jobTitle(employee.getJobTitle())
                .salary(employee.getSalary())
                .build();
    }

}
