package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.ExperienceService;
import com.example.hrms.business.abstracts.LanguageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.CvExperience;
import com.example.hrms.entities.concretes.CvLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/language")
public class LanguageController {
    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    DataResult<List<CvLanguage>> getAll(){
        return this.languageService.getAll();
    }

    @PostMapping("/add")
    Result add(@RequestBody CvLanguage cvLanguage){
        return this.languageService.add(cvLanguage);
    }
}
