package com.devops.springboot_app.controller;

import com.devops.springboot_app.dto.ApiResponse;
import com.devops.springboot_app.dto.EmployeeRequest;
import com.devops.springboot_app.dto.EmployeeResponse;
import com.devops.springboot_app.service.EmployeeService;
import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
    name = "Employee Management",
    description = "Employee CRUD REST APIs"
)

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private static final Logger logger =
            LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(
        summary = "Create Employee",
        description = "Creates a new employee in the database."
    )

    @PostMapping
    public ApiResponse<EmployeeResponse> createEmployee(
            @Valid @RequestBody EmployeeRequest request) {

        logger.info("Creating employee : {}", request.getEmployeeId());

        EmployeeResponse response =
                employeeService.createEmployee(request);

        return new ApiResponse<>(
                true,
                "Employee created successfully",
                response
        );
    }
    
    @Operation(
        summary = "Get All Employees",
        description = "Returns all employees."
    )

    @GetMapping
    public ApiResponse<List<EmployeeResponse>> getAllEmployees() {

        logger.info("Fetching all employees");

        return new ApiResponse<>(
                true,
                "Employees fetched successfully",
                employeeService.getAllEmployees()
        );
    }

    @Operation(
        summary = "Get Employee By ID",
        description = "Returns an employee using the database ID."
    )

    @GetMapping("/{id}")
    public ApiResponse<EmployeeResponse> getEmployeeById(
            @PathVariable Long id) {

        logger.info("Fetching employee {}", id);

        return new ApiResponse<>(
                true,
                "Employee fetched successfully",
                employeeService.getEmployeeById(id)
        );
    }

    @Operation(
        summary = "Update Employee",
        description = "Updates an existing employee."
    )
    @PutMapping("/{id}")
    public ApiResponse<EmployeeResponse> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequest request) {

        logger.info("Updating employee {}", id);

        return new ApiResponse<>(
                true,
                "Employee updated successfully",
                employeeService.updateEmployee(id, request)
        );
    }

    @Operation(
        summary = "Delete Employee",
        description = "Deletes an employee by ID."
    )
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteEmployee(
            @PathVariable Long id) {

        logger.info("Deleting employee {}", id);

        employeeService.deleteEmployee(id);

        return new ApiResponse<>(
                true,
                "Employee deleted successfully",
                null
        );
    }
}