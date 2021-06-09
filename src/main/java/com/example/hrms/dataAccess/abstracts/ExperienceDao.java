package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.CvExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceDao extends JpaRepository<CvExperience,Integer> {
}
