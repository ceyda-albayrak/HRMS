package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.ImageService;
import com.example.hrms.core.utilities.imageUpload.ImageUploadService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.ImageDao;
import com.example.hrms.entities.concretes.CvImage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class CvImageManager implements ImageService {


    private ImageDao imageDao;
    private ImageUploadService uploadService;

    public CvImageManager(ImageDao imageDao, ImageUploadService uploadService) {
        this.imageDao = imageDao;
        this.uploadService=uploadService;
    }

    @Override
    public Result add(CvImage cvImage, MultipartFile imageFile) {
        @SuppressWarnings("unchecked")
        Map<String,String> uploadImage = this.uploadService.uploadImageFile(imageFile).getData();
        cvImage.setUrl(uploadImage.get("url"));
        this.imageDao.save(cvImage);
        return new SuccessResult("kaydedildi");
    }
}
