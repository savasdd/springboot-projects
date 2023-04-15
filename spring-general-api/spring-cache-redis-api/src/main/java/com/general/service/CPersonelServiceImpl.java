package com.general.service;

import com.general.dao.CPersonel;
import com.general.dao.MetaData;
import com.general.repository.CPersonelRepository;
import com.general.util.CommonUtils;
import com.general.util.CustomCachingAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

    public CPersonelServiceImpl(CPersonelRepository personelRepository) {
        this.personelRepository = personelRepository;
    }

    //Cache isleminin doğru çalışması için crud işlemlerinden sonra cache update edilmelidir
    @CacheEvict(value= CommonUtils.cache, allEntries=true) //update cache
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

    @CacheEvict(value= CommonUtils.cache, allEntries=true) //update cache
    @Override
    @Transactional
    public CPersonel update(Long id, CPersonel dto) throws Exception {
        var personels=personelRepository.findById(id);
        var updateModel=personels.map(val->{
            val.setTc(dto.getTc());
            val.setName(dto.getName());
            val.setSurname(dto.getSurname());
            val.setTax(dto.getTax());
            return val;
        }).orElseThrow(()->new Exception("not found"));

        var model=personelRepository.save(updateModel);
        log.info("update personel");

        return model;
    }

    @Cacheable(value = CommonUtils.cache)
    @Override
    @Transactional
    public List<CPersonel> getAllCache() {
        var list=personelRepository.findAll();
        log.info("list CPersonel {} ",list.size());
        return list;
    }

    @CustomCachingAnnotation //custom olarak generate edildi
    @Override
    public List<CPersonel> getAllCacheCustom() {
        var list=personelRepository.getAll();
        log.info("list CPersonel {} ",list.size());
        return list;
    }

    @Override
    @Transactional
    public CPersonel getById(Long id) {
        var model=personelRepository.findById(id);
        log.info("findById CPersonel {} ",id);
        return model.isPresent()?model.get():null;
    }

    @CacheEvict(value= CommonUtils.cache, allEntries=true) //update cache
    @Override
    @Transactional
    public void delete(Long id) {
        personelRepository.deleteById(id);
        log.info("delete personel {} ",id);
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
