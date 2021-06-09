package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.PositionService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
public class PositionController {

    private PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/getall")
    public DataResult<List<Position>> getAll(){
        return this.positionService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Position position){
        return this.positionService.add(position);
    }
}
