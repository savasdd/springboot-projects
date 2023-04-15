package com.general.dao;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TUNIT",schema = "flyway")
public class Unit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CODE")
    private String code;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "EMAIL")
    private String email;

//    @Column(name = "PHONE")
//    private String phone;

    @Column(name = "COUNT")
    private Integer count;

}
