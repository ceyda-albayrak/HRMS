package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name="cv_educations")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class CvEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int educationId;

    @Column(name="school_name")
    private String schoolName;

    @Column(name="department")
    private String department;

    @Column(name="starting_date")
    private Date startingDate;

    @Column(name="graduation_date")
    private Date graduationDate;

    @Column(name="cv_id")
    private int cvId;




}
