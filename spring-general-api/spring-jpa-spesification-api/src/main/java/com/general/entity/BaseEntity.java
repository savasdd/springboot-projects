package com.general.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Index;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1656703245648711747L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Column(name = "createdDate", updatable = false)
    private Date createdDate;

    @JsonIgnore
    @Column(name = "updatedDate")
    private Date updatedDate;

    @JsonIgnore
    @Index(name = "isDeleted")
    @Column(name = "isDeleted", nullable = false)
    private Long isDeleted;

    @PreUpdate
    public void setPreUpdate() {
        this.updatedDate = new Date();
    }

    @PrePersist
    public void setPrePersist() {
        this.createdDate = new Date();
        this.isDeleted = 0L;
    }

}
