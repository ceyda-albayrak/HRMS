package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EducationService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EducationDao;
import com.example.hrms.entities.concretes.CvEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public DataResult<List<CvEducation>> getAll() {
        return new SuccessDataResult<List<CvEducation>>(this.educationDao.findAll());
    }

    @Override
    public Result add(CvEducation education) {
        this.educationDao.save(education);
        return new SuccessResult("kaydedildi");
    }
}
