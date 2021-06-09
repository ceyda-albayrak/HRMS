package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.ExperienceService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.ExperienceDao;
import com.example.hrms.entities.concretes.CvExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceManager implements ExperienceService {

    private ExperienceDao experienceDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao) {
        this.experienceDao = experienceDao;
    }

    @Override
    public DataResult<List<CvExperience>> getAll() {
        return new SuccessDataResult<List<CvExperience>>(this.experienceDao.findAll());
    }

    @Override
    public Result add(CvExperience experience) {
        this.experienceDao.save(experience);
        return new SuccessResult("kaydedildi");
    }
}
