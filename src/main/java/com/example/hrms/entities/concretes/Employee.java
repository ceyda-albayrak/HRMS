package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name="employees")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employee"})
public class Employee extends User{

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="tc_no")
    private String tcNo;

    @Column(name="birth_date")
    private Date birthDate;


    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<CvCoverLetter> letters;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<CvImage> images;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<CvEducation> educations;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<CvExperience> experiences;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<CvLanguage> languages;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<CvLink> links;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<CvTechnology> technologies;

}
