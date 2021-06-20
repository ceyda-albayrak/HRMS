package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.AdvertService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.entities.concretes.Advert;
import com.example.hrms.entities.dtos.AdvertDetailsDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adverts")
@CrossOrigin
public class AdvertController {
    private AdvertService advertService;

    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @GetMapping("/getall")
    public DataResult<List<Advert>> getAll(){
        return this.advertService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Advert advert){
        return this.advertService.add(advert);
    }

    @GetMapping("/getadvertdetails")
    public DataResult<List<AdvertDetailsDto>> getAdvertDetails(){
        return this.advertService.getAdvertDetails();
    }

    @GetMapping("/getbyadvertsuserid")
    public DataResult<List<AdvertDetailsDto>>  getByAdverts(@RequestParam("userId") int companyId)
    {
        return this.advertService.getAdvertDetailsCompany(companyId);
    }

    @GetMapping("/getbyadvertsdate")
    public DataResult<List<AdvertDetailsDto>> getAdvertsDate(){
        return this.advertService.getAdvertsDate();
    }

    @PostMapping("/closedAdvert")
    public Result closeAdvert(int advertId){
        return this.advertService.closeAdvert(advertId);
    }
}
