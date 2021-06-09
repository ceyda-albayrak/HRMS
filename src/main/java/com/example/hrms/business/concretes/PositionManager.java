package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.PositionService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.core.utilities.rules.RunRules;
import com.example.hrms.dataAccess.abstracts.PositionDao;
import com.example.hrms.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //servis görevi görecek class(business)
public class PositionManager implements PositionService {
    private PositionDao positionDao;

    @Autowired //jobpositionmanager görünce jobpositionsdao instance oluşturuyor. Autofac gibi..
    public PositionManager(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Override
    public DataResult<List<Position>> getAll() {
        return new SuccessDataResult<List<Position>>(this.positionDao.findAll(),"Data başarıyla listelendi");
    }

    @Override
    public Result add(Position position) {
        Result result= RunRules.run(positionControl(position.getPosition()));
        if(result.isSuccess()){
            this.positionDao.save(position);
            return new SuccessResult(result.getMessage());
        }
        return new ErrorResult(result.getMessage());
    }

    private Result positionControl(String position)
    {
        if(positionDao.findAllByPosition(position).size()!=0){
            return new ErrorResult("Bu pozisyon zaten kayıtlı!");
        }
        return new SuccessResult("Başarılı");
    }

}
