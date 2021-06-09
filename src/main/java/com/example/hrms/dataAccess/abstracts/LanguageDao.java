package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.CvLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao extends JpaRepository<CvLanguage,Integer> {
}
