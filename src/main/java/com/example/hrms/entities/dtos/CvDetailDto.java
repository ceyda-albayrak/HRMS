package com.example.hrms.entities.dtos;

import com.example.hrms.entities.concretes.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDetailDto {

    private List<Employee> employee;
    private List<CvExperience> experiences;
    private List<CvLanguage> languages;
    private List<CvCoverLetter> letters;
    private List<CvEducation> educations;
    private List<CvImage> images;
    private List<CvLink> links;
    private List<CvTechnology> technologies;





}
