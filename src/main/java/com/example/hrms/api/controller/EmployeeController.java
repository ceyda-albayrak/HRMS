package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.EmployeeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employee;
import com.example.hrms.entities.dtos.CvDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employee>> getAll(){
         return this.employeeService.getAll();
    }

    @PostMapping("/add")
    public Result Add(@RequestBody Employee employee){
        return this.employeeService.add(employee);
    }

    @GetMapping("/getCvById")
    public CvDetailDto getCvById(int id){
        return this.employeeService.getCvById(id);
    }
}
