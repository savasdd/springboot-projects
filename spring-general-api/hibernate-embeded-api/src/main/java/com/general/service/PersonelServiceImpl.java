package com.general.service;

import com.general.dao.MetaData;
import com.general.dao.Personel;
import com.general.dao.PersonelType;
import com.general.repository.PersonelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonelServiceImpl implements PersonelService {

    private final PersonelRepository repository;

    @Override
    @Transactional
    public Personel createPersonel(){
        double tax=0.0;
        tax=tax+2;
        Personel personel= Personel.builder().name("savas").surname("dede").tax(2.0*tax).personelType(PersonelType.NORMAL).build();
        MetaData data=new MetaData();
        data.setCreateDate(LocalDateTime.now());
        personel.setMetaData(data);

        var dao=repository.save(personel);

        log.info("create personel {} ",dao.getId());
        return dao;
    }

    @Override
    @Transactional
    public List<Personel> getPersonel(){
        log.info("get all personel");
        String name = "savas",surname="dede";

        var listTotal=repository.getTotal();
        var search=repository.searchPersonel("savas",null,null, PageRequest.of(0,20));
        var searchLike=repository.searchPersonel(name!=null?name:"",surname!=null?surname:"",null, PageRequest.of(0,20));

        return repository.findAll();
    }

}
