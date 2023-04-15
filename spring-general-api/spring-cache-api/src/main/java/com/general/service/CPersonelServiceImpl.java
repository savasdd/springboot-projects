package com.general.service;

import com.general.dao.CPersonel;
import com.general.dao.MetaData;
import com.general.repository.CPersonelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CPersonelServiceImpl implements CPersonelService{

    private final CPersonelRepository personelRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public CPersonelServiceImpl(CPersonelRepository personelRepository) {
        this.personelRepository = personelRepository;
    }

    @Override
    @Transactional
    public CPersonel create(CPersonel personel) {
        MetaData data=MetaData.builder().createDate(LocalDateTime.now()).build();
        personel.setMetaData(data);
        var model=personelRepository.save(personel);
        log.info("create CPersonel {} ",model.getId());
        //createAll();
        return model;
    }

    //@Cacheable("personels")
    @CacheEvict(value="personels", allEntries=true)
    @Override
    @Transactional
    public List<CPersonel> getAll() {
        var list=personelRepository.findAll();
        log.info("list CPersonel {} ",list.size());
        return list;
    }

    //@CustomCachingAnnotation
    @CacheEvict(value="personels", allEntries=true) //delete and re insert cache
    @Override
    @Transactional
    public CPersonel getById(Long id) {
        var model=personelRepository.findById(id);
        log.info("findById CPersonel {} ",id);
        return model.isPresent()?model.get():null;
    }

    private void createAll(){
        List<CPersonel> list=new ArrayList<>();
        for (int i=0;i<1000;i++){
            var model=CPersonel.builder().tc(Long.valueOf(12345687+i)).name("Savaş "+i).surname("Dede "+i).tax(15D).build();
            list.add(model);
        }

        if(!list.isEmpty())
            personelRepository.saveAll(list);
    }
}
