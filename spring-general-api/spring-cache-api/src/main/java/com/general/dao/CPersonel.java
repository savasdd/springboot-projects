package com.general.dao;

import lombok.*;
import org.springframework.cache.annotation.CacheConfig;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
//@Cache(usage= CacheConcurrencyStrategy.READ_WRITE, region="CPERSONEL")
@Entity
@Table(name = "CPERSONEL")
@CacheConfig(cacheNames={"personel"})
public class CPersonel implements Serializable {

    private static final long serialVersionUID = 1L;

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

    private MetaData metaData;
}
