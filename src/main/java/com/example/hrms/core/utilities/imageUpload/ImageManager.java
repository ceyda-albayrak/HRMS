package com.example.hrms.core.utilities.imageUpload;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageManager implements ImageUploadService{

    private Cloudinary cloudinary;
    @Autowired
    public ImageManager() {

        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name","rain-consultancy",
                "api_key", "838167715234411",
                "api_secret","b0Uj40j8GVmJM7UKTPlvZfDUO_4"

        ));

    }

    @SuppressWarnings("rawtypes")
    @Override
    public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
        try {
            @SuppressWarnings("unchecked")
            Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(resultMap);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return new ErrorDataResult<Map>();
    }
}
