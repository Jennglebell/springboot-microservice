package net.jennglebell.employeeservice.service;

import net.jennglebell.employeeservice.dto.APIResponseDto;
import net.jennglebell.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployee(Long employeeId);
}
