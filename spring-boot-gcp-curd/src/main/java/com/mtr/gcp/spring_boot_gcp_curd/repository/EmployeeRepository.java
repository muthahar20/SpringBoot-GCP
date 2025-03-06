package com.mtr.gcp.spring_boot_gcp_curd.repository;

import com.mtr.gcp.spring_boot_gcp_curd.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
