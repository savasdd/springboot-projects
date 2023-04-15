package com.general.service;

import com.general.dao.Unit;
import com.general.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UnitServiceImpl implements UnitService{

    private final UnitRepository unitRepository;

    @Override
    @Transactional
    public Unit createUnit(){
        var unit=Unit.builder().name("ETKB").code("202").email("etkb@enerji.gov.tr").location("ANKARA").count(272).build();
        var dao=unitRepository.save(unit);

        log.info("create unit {} ",dao.getId());
        return dao;
    }

    @Override
    @Transactional
    public List<Unit> getUnit(){
        log.info("get all unit");
        return unitRepository.findAll();
    }

    @Override
    @Transactional
    public Unit updateUnit(Long id){
        var unit=unitRepository.findById(id);
        if(unit.isPresent()){
            unit.get().setName(unit.get().getName()+"_1");
            unit.get().setCode(unit.get().getCode()+"_2");
            var dao=unitRepository.save(unit.get());
            log.info("update unit {} ",dao.getId());

            return dao;
        }else
            return null;
    }

    @Override
    @Transactional
    public void deleteUnit(Long id) {
        unitRepository.deleteById(id);
        log.info("delete unit {} ",id);
    }
}
