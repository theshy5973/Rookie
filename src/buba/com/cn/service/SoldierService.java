package buba.com.cn.service;

import buba.com.cn.entity.Soldier;

import java.util.List;

public interface SoldierService {
    List<Soldier> findAllSoldiers();
    int addSoldiers(Soldier soldier);
    int deleteSoldierById(Integer soldier);
    int updateSoldierById(Soldier soldier);
}
