package com.example.hrms.api.controller;


import com.example.hrms.business.abstracts.CoverLetterService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Company;
import com.example.hrms.entities.concretes.CvCoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/covers")
public class CoverLetterController {
    private CoverLetterService coverLetterService;

    @Autowired
    public CoverLetterController(CoverLetterService coverLetterService) {
        this.coverLetterService = coverLetterService;
    }

    @GetMapping("/getall")
    DataResult<List<CvCoverLetter>> getAll(){
        return this.coverLetterService.getAll();
    }

    @PostMapping("/add")
    Result add(@RequestBody CvCoverLetter coverLetter){
        return this.coverLetterService.add(coverLetter);
    }
}
