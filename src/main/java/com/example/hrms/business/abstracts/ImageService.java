package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.CvCoverLetter;
import com.example.hrms.entities.concretes.CvImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    DataResult<List<CvImage>> getAll();
    Result add(int imageId, MultipartFile url);
}
