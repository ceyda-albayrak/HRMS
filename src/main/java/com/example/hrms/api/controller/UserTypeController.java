package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.UserTypeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.UserType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class UserTypeController {

    private UserTypeService userTypeService;

    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @GetMapping("/getall")
    public DataResult<List<UserType>> getAll(){
        return this.userTypeService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody UserType type){
        return this.userTypeService.add(type);
    }
}
