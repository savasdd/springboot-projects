package com.general.dao;

import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TPERSONEL")
public class Personel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TC")
    private Long tc;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Enumerated(EnumType.STRING)
    private PersonelType personelType;

    @Column(name = "TAX")
    private Double tax;

    @Formula("tax * 18.5")
    private Double price;

    private MetaData metaData;
}
