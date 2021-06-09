package com.example.hrms.api.controller;


import com.example.hrms.business.abstracts.ImageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.entities.concretes.CvImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/getall")
    public DataResult<List<CvImage>> getAll(){
        return this.imageService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestParam(value="imageId") int imageId, @RequestParam(value="url")MultipartFile url){
        return this.imageService.add(imageId,url);
    }


}
