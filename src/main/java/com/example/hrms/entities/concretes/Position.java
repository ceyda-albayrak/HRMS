package com.example.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity //Annotations->Classın çalışma anında bilgi toplama yapmak icin kullanılır.Attribute gibi.
@Table(name="positions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int positionId;

    @Column(name="position_name")
    private String position;

    @OneToMany(mappedBy = "position")
    private List<Advert> adverts;



}
