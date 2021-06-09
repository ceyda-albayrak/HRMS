package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.LanguageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.LanguageDao;
import com.example.hrms.entities.concretes.CvLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public DataResult<List<CvLanguage>> getAll() {
        return new SuccessDataResult<List<CvLanguage>>(this.languageDao.findAll());
    }

    @Override
    public Result add(CvLanguage language) {
        this.languageDao.save(language);
        return new SuccessResult("kaydedildi");
    }
}
