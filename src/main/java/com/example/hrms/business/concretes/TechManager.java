package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.TechService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.TechDao;
import com.example.hrms.entities.concretes.CvTechnology;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechManager implements TechService {

    private TechDao techDao;

    public TechManager(TechDao techDao) {
        this.techDao = techDao;
    }

    @Override
    public DataResult<List<CvTechnology>> getAll() {
        return new SuccessDataResult<List<CvTechnology>>(this.techDao.findAll());
    }

    @Override
    public Result add(CvTechnology technology) {
        this.techDao.save(technology);
        return new SuccessResult("kaydedildi");
    }
}
