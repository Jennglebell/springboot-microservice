package net.jennglebell.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.jennglebell.employeeservice.dto.APIResponseDto;
import net.jennglebell.employeeservice.dto.DepartmentDto;
import net.jennglebell.employeeservice.dto.EmployeeDto;
import net.jennglebell.employeeservice.entity.Employee;
import net.jennglebell.employeeservice.repository.EmployeeRepository;
import net.jennglebell.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private final WebClient.Builder webClientBuilder;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstname(),
                employeeDto.getLastname(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstname(),
                savedEmployee.getLastname(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );

        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

        WebClient webClient = webClientBuilder.build();
        DepartmentDto departmentDto = webClient.get()
                .uri("http://DEPARTMENT-SERVICE/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }
}
