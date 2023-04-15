package com.general.dao;

import com.general.util.CommonUtils;
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
@Entity
@Table(name = "CPERSONEL")
@CacheConfig(cacheNames={CommonUtils.cache})
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
