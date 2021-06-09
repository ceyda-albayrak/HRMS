package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.LinkService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.LinkDao;
import com.example.hrms.entities.concretes.CvLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkManager implements LinkService {

    private LinkDao linkDao;

    @Autowired
    public LinkManager(LinkDao linkDao) {
        this.linkDao = linkDao;
    }

    @Override
    public DataResult<List<CvLink>> getAll() {
        return new SuccessDataResult<List<CvLink>>(this.linkDao.findAll());
    }

    @Override
    public Result add(CvLink link) {
        this.linkDao.save(link);
        return new SuccessResult("kaydedildi");
    }
}
