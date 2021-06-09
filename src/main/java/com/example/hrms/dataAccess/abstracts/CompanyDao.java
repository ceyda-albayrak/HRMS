package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CompanyDao extends JpaRepository<Company, Integer> {
    List<Company> findAllByEmail(String email);

}
