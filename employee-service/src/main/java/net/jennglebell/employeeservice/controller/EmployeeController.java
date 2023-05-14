package net.jennglebell.employeeservice.controller;

import lombok.AllArgsConstructor;
import net.jennglebell.employeeservice.dto.APIResponseDto;
import net.jennglebell.employeeservice.dto.EmployeeDto;
import net.jennglebell.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    // save employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // get employee REST API
    @GetMapping("{employee_id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("employee_id") Long employeeId) {
        APIResponseDto apiResponseDto = employeeService.getEmployee(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
