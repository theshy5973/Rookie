package buba.com.cn.service.impl;

import buba.com.cn.dao.SoldierDao;
import buba.com.cn.dao.impl.SoldierDaoImpl;
import buba.com.cn.entity.Soldier;
import buba.com.cn.service.SoldierService;

import java.util.List;

public class SoldierServiceImpl implements SoldierService {
    private SoldierDao soldierDao = new SoldierDaoImpl();
    @Override
    public List<Soldier> findAllSoldiers() {
        return soldierDao.findAllSoldiers();
    }

    @Override
    public int addSoldiers(Soldier soldier) {
        return soldierDao.addSoldiers(soldier);
    }

    @Override
    public int deleteSoldierById(Integer soldier) {
        return soldierDao.deleteSoldierById(soldier);
    }

    @Override
    public int updateSoldierById(Soldier soldier) {
        return soldierDao.updateSoldierById(soldier);
    }
}
