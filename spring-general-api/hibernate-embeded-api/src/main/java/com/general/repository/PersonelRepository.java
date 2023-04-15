package com.general.repository;

import com.general.dao.Personel;
import com.general.dao.TotalPresonel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonelRepository extends JpaRepository<Personel,Long> {

    @Query("select v.name as name, count(v.id) as count from Personel v group by v.name order by v.name")
    List<TotalPresonel> getTotal();

    @Query("select v from Personel v " +
            "where (:pname is null or v.name like %:pname%) " +
            "and (:psurname is null or v.surname like %:psurname%) " +
            "and (:ptc is null or v.tc = :ptc)")
    List<Personel> searchPersonel(String pname, String psurname, Long ptc, Pageable pageable);

    @Query("select v from Personel v " +
            "where (:pname is null or upper(v.name) like upper(concat('%',:pname,'%'))) " +
            "and (:psurname is null or upper(v.surname) like upper(concat('%',:psurname,'%'))) " +
            "and (:ptc is null or v.tc = :ptc)")
    List<Personel> searchPersonelLike(String pname, String psurname, Long ptc, Pageable pageable);
}
