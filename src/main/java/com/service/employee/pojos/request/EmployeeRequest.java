package com.service.employee.pojos.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequest {
    private String name;
    private String department;
    private String jobTitle;
    private Double salary;
}
