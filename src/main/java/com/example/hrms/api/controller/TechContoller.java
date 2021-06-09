package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.LinkService;
import com.example.hrms.business.abstracts.TechService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.CvTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tech")
public class TechContoller {
    private TechService techService;

    @Autowired
    public TechContoller (TechService techService) {
        this.techService = techService;
    }

    @GetMapping("/getall")
    DataResult<List<CvTechnology>> getAll(){
        return this.techService.getAll();
    }

    @PostMapping("/add")
    Result add(@RequestBody CvTechnology cvTechnology){
        return this.techService.add(cvTechnology);
    }
}
