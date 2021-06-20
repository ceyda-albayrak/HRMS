package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@Data
@Table(name="cv_languages")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employee"})
public class CvLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @JsonIgnore
    private int languageId;

    @Column(name="language_name")
    private String languageName;

    @Column(name="level")
    @Min(1)
    @Max(5)
    private int level;

    @Column(name="cv_id")
    private int cvId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cv_id",updatable = false,insertable = false)
    Employee employee;


}
