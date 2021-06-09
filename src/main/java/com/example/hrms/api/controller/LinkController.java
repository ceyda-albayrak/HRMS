package com.example.hrms.api.controller;


import com.example.hrms.business.abstracts.LinkService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;

import com.example.hrms.entities.concretes.CvLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/link")
public class LinkController {
    private LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/getall")
    DataResult<List<CvLink>> getAll(){
        return this.linkService.getAll();
    }

    @PostMapping("/add")
    Result add(@RequestBody CvLink cvLink){
        return this.linkService.add(cvLink);
    }
}
