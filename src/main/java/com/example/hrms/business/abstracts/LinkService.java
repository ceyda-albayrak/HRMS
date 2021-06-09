package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.CvCoverLetter;
import com.example.hrms.entities.concretes.CvLink;

import java.util.List;

public interface LinkService {
    DataResult<List<CvLink>> getAll();
    Result add(CvLink link);
}
