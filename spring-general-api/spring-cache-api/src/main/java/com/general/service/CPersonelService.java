package com.general.service;

import com.general.dao.CPersonel;

import java.util.List;

public interface CPersonelService {

    public CPersonel create(CPersonel personel);
    public CPersonel update(Long id,CPersonel personel) throws Exception;
    public List<CPersonel> getAllCache();
    public List<CPersonel> getAllCacheCustom();
    public CPersonel getById(Long id);
    public void delete(Long id);



}
