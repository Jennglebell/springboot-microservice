package net.jennglebell.employeeservice.Mapper;

import net.jennglebell.employeeservice.dto.EmployeeDto;
import net.jennglebell.employeeservice.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto (Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail(),
                employee.getDepartmentCode(),
                employee.getOrganizationCode()
        );
        return employeeDto;
    }

    public static Employee mapToEmployee (EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstname(),
                employeeDto.getLastname(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode(),
                employeeDto.getOrganizationCode()
        );
        return employee;
    }

}
