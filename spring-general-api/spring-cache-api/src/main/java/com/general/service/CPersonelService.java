package com.general.service;

import com.general.dao.CPersonel;

import java.util.List;

public interface CPersonelService {

    public CPersonel create(CPersonel personel);
    public List<CPersonel> getAll();
    public CPersonel getById(Long id);
}
