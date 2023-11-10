package com.general.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity(name = "Person")
@Table(indexes = {
        @Index(name = "IDX_person_isDeleted", columnList = "isDeleted"),
        @Index(name = "IDX_person_name", columnList = "name"),
        @Index(name = "IDX_person_surName", columnList = "surName"),
}, uniqueConstraints = {@UniqueConstraint(columnNames = {"identityNumber", "isDeleted"})})
@SQLDelete(sql = "UPDATE person SET is_deleted = id WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "is_deleted = 0")
public class Person extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -48260237983492874L;

    @Column(name = "identityNumber", nullable = false)
    private String identityNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surName")
    private String surName;

    @Column(name = "birthDate")
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "department", referencedColumnName = "id")
    @JsonBackReference("person")
    private Department department;

}
