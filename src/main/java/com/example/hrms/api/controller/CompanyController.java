package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.CompanyService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies/")
public class CompanyController {
    private CompanyService companyService;
    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/getall")
    DataResult<List<Company>> getAll(){
       return this.companyService.getAll();
    }

    @PostMapping("/add")
    Result add(@RequestBody Company employer){
        return this.companyService.add(employer);
    }
}
