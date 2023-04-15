package com.general.service;

import com.general.dao.Unit;

import java.util.List;

public interface UnitService {

    public Unit createUnit();

    public List<Unit> getUnit();

    public Unit updateUnit(Long id);

    public void deleteUnit(Long id);
}
