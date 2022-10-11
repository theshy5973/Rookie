package buba.com.cn.dao;

import buba.com.cn.entity.Soldier;

import java.util.List;

public interface SoldierDao {
    List<Soldier> findAllSoldiers();
    int addSoldiers(Soldier soldier);
    int deleteSoldierById(Integer soldier);
    int updateSoldierById(Soldier soldier);
}
