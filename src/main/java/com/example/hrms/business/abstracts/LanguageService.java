package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.CvCoverLetter;
import com.example.hrms.entities.concretes.CvLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageService {
    DataResult<List<CvLanguage>> getAll();
    Result add(CvLanguage language);
}
