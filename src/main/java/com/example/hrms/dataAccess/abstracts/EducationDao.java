package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.CvEducation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDao extends JpaRepository<CvEducation,Integer> {
}
