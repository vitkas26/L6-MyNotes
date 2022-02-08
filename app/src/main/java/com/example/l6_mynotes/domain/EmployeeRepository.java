package com.example.l6_mynotes.domain;

import java.util.List;

public interface EmployeeRepository {
    List<EmployeeEntity> getEmployees();

    void deleteEmployees(EmployeeEntity employeeEntity);
}
