package net.jennglebell.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.jennglebell.departmentservice.dto.DepartmentDto;
import net.jennglebell.departmentservice.entity.Department;
import net.jennglebell.departmentservice.mapper.DepartmentMapper;
import net.jennglebell.departmentservice.repository.DepartmentRepository;
import net.jennglebell.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // convert DepartmentDto to Department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
    }
}
