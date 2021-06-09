package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.CvService;
import com.example.hrms.business.abstracts.EducationService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Cv;
import com.example.hrms.entities.concretes.CvEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationController {
    private EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/getall")
    DataResult<List<CvEducation>> getAll(){
        return this.educationService.getAll();
    }

    @PostMapping("/add")
    Result add(@RequestBody CvEducation cvEducation){
        return this.educationService.add(cvEducation);
    }
}
