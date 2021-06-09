package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.EducationService;
import com.example.hrms.business.abstracts.ExperienceService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.CvEducation;
import com.example.hrms.entities.concretes.CvExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {
    private ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("/getall")
    DataResult<List<CvExperience>> getAll(){
        return this.experienceService.getAll();
    }

    @PostMapping("/add")
    Result add(@RequestBody CvExperience cvExperience){
        return this.experienceService.add(cvExperience);
    }
}
