package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.CvCoverLetter;
import com.example.hrms.entities.concretes.CvEducation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationService {
    DataResult<List<CvEducation>> getAll();
    Result add(CvEducation education);
}
