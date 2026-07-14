package com.devops.springboot_app.service.impl;

import com.devops.springboot_app.dto.EmployeeRequest;
import com.devops.springboot_app.dto.EmployeeResponse;
import com.devops.springboot_app.entity.Employee;
import com.devops.springboot_app.exception.DuplicateEmployeeException;
import com.devops.springboot_app.exception.EmployeeNotFoundException;
import com.devops.springboot_app.mapper.EmployeeMapper;
import com.devops.springboot_app.repository.EmployeeRepository;
import com.devops.springboot_app.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    public EmployeeServiceImpl(EmployeeRepository repository,EmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request) {

        if (repository.existsByEmail(request.getEmail())) {
            throw new DuplicateEmployeeException(
                "Email",
                request.getEmail());
        }

        if (repository.existsByEmployeeId(request.getEmployeeId())) {
            throw new DuplicateEmployeeException(
                "Employee ID",
                request.getEmployeeId());
        }

        Employee employee = mapper.toEntity(request);

        Employee savedEmployee = repository.save(employee);

        return mapper.toResponse(savedEmployee);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {

        return repository.findAll()
            .stream()
            .map(mapper::toResponse)
            .toList();
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {

        Employee employee = repository.findById(id)
            .orElseThrow(() ->
                    new EmployeeNotFoundException(id));

        return mapper.toResponse(employee);
    }

    @Override
    public EmployeeResponse updateEmployee(Long id,
                                       EmployeeRequest request) {

        Employee existing = repository.findById(id)
            .orElseThrow(() ->
                    new EmployeeNotFoundException(id));

        existing.setFirstName(request.getFirstName());
        existing.setLastName(request.getLastName());
        existing.setDepartment(request.getDepartment());
        existing.setDesignation(request.getDesignation());
        existing.setSalary(request.getSalary());

        Employee updatedEmployee = repository.save(existing);

        return mapper.toResponse(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee employee = repository.findById(id)
            .orElseThrow(() ->
                    new EmployeeNotFoundException(id));

        repository.delete(employee);
}
}