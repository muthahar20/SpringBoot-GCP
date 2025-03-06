package com.mtr.gcp.spring_boot_gcp_curd.controller;

import com.mtr.gcp.spring_boot_gcp_curd.entity.Employee;
import com.mtr.gcp.spring_boot_gcp_curd.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/employees")
@Tag(name = "Employee Management", description = "Operations related to Employee management")
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController( EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getMsg(){
        return "<h1 style = font-color=red><center><br><br><br>Spring boot Application with File Upload Features </center></h1>";
    }
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEployees();
    }


    @PostMapping
    @Operation(summary = "Create Employee", description = "Create a new Employee with provided details")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Employee by ID", description = "Retrieve Employee details by providing an ID")

    public ResponseEntity<Employee> getEmployeeById( @PathVariable(value ="id") Long id)
    {
        Employee employee = employeeService.getEmployee(id);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<Employee> updateEployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return updatedEmployee !=null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }



}
