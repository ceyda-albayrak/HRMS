package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.ImageService;
import com.example.hrms.core.utilities.imageUpload.ImageUploadService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.ImageDao;
import com.example.hrms.entities.concretes.CvImage;
import com.example.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class ImageManager implements ImageService {

    private ImageDao imageDao;
    private ImageUploadService uploadService;

    @Autowired
    public ImageManager(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    @Override
    public DataResult<List<CvImage>> getAll() {
        return new SuccessDataResult<List<CvImage>>(this.imageDao.findAll());
    }

    @Override
    public Result add(int imageId, MultipartFile imageFile) {
        @SuppressWarnings("unchecked")
        Map<String,String> sample=(Map<String,String>)
        this.uploadService.uploadImageFile(imageFile).getData();
        User user=new User();
        CvImage cvImage=new CvImage();
        user.setUserId(imageId);
        cvImage.setUser(user);


        cvImage.setUrl(sample.get("url"));
        this.imageDao.save(cvImage);
        return new SuccessResult("eklendi");
    }
}
