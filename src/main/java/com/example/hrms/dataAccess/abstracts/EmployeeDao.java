package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeDao extends JpaRepository<Employee,Integer> {
    List<Employee> findAllByEmailAndTcNo(String email,String tcno);
    List<Employee> findAllByEmail(String email);
    Employee getById(int id);
}
