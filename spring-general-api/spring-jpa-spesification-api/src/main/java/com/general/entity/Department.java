package com.general.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "Department")
@Table(indexes = {
        @Index(name = "IDX_department_isDeleted", columnList = "isDeleted"),
        @Index(name = "IDX_department_level", columnList = "level"),
        @Index(name = "IDX_department_name", columnList = "name"),
}, uniqueConstraints = {
        @UniqueConstraint(columnNames = {"code", "isDeleted"})
})
@SQLDelete(sql = "UPDATE department SET is_deleted = id WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "is_deleted = 0")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Department extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -4717369202307667809L;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "level")
    private Integer level;

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    @JsonManagedReference("person")
    private Set<Person> personSet = new HashSet<>();

}
