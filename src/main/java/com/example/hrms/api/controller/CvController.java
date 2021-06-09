package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.CoverLetterService;
import com.example.hrms.business.abstracts.CvService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Cv;
import com.example.hrms.entities.concretes.CvCoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cv")
public class CvController {
    private CvService cvService;

    @Autowired
    public CvController(CvService cvService) {
        this.cvService = cvService;
    }

    @GetMapping("/getall")
    DataResult<List<Cv>> getAll(){
        return this.cvService.getAll();
    }

    @PostMapping("/add")
    Result add(@RequestBody Cv cv){
        return this.cvService.add(cv);
    }
}
