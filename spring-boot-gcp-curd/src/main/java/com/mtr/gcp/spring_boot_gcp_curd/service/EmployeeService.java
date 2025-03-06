package com.mtr.gcp.spring_boot_gcp_curd.service;

import com.mtr.gcp.spring_boot_gcp_curd.entity.Employee;
import com.mtr.gcp.spring_boot_gcp_curd.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {



    private final EmployeeRepository employeeRepository;

    public EmployeeService( EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEployees(){
        return employeeRepository.findAll();
    }

    public Employee createEmployee( Employee employee) {

        return employeeRepository.save(employee);
    }

    public Employee getEmployee(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails){
       Employee employee1 = employeeRepository.findById(id).orElse(null);
      if( employee1 != null){
          employee1.setFirstName( employeeDetails.getFirstName());
          employee1.setFirstName( employeeDetails.getLastName());
          employee1.setEmailId(employeeDetails.getEmailId());
          return employeeRepository.save(employee1);
      }
       return null;
    }


    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }




}
