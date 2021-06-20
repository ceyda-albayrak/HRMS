package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.EmployeeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employee;
import com.example.hrms.entities.dtos.CvDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
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
    public ResponseEntity<?> Add(@Valid @RequestBody Employee employee){
        return ResponseEntity.ok(this.employeeService.add(employee));
    }

    @GetMapping("/getCvById")
    public CvDetailDto getCvById(int id){
        return this.employeeService.getCvById(id);
    }




}
