package com.example.hrms.core.adapers.concretes;

import com.example.hrms.core.adapers.abstracts.MernisCheckService;
import com.example.hrms.entities.concretes.Employee;
import com.example.hrms.mernisService.DAKKPSPublicSoap;
import org.springframework.stereotype.Service;

@Service
public class MernisCheckServiceAdapter implements MernisCheckService {
    @Override
    public boolean mernisCheck(Employee employee) {
        int year=employee.getBirthDate().getYear()+1900;
        long tcno=Long.valueOf(employee.getTcNo());
        DAKKPSPublicSoap publicSoap=new DAKKPSPublicSoap();
        try{
            return publicSoap.TCKimlikNoDogrula(tcno,employee.getFirstName().toUpperCase(),employee.getLastName().toUpperCase(),year);
        }
        catch (Exception e)
        {
            e.printStackTrace();;
        }
        return false;
    }
}
