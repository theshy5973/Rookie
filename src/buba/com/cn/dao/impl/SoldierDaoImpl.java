package buba.com.cn.dao.impl;

import buba.com.cn.dao.SoldierDao;
import buba.com.cn.entity.Soldier;
import buba.com.cn.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SoldierDaoImpl implements SoldierDao {
    @Override
    public List<Soldier> findAllSoldiers() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "select * from t_soldier";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Soldier.class));
    }

    @Override
    public int addSoldiers(Soldier soldier) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "insert into t_soldier(soldier_name, soldier_weapon) values(?, ?)";
        return jdbcTemplate.update(sql,soldier.getSoldierName(),soldier.getSoldierWeapon());
    }

    @Override
    public int deleteSoldierById(Integer soldier) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "delete from t_soldier where soldier_id = ?";
        return jdbcTemplate.update(sql,Integer.valueOf(soldier));
    }

    @Override
    public int updateSoldierById(Soldier soldier) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "update t_soldier set soldier_name=?,soldier_weapon=? where soldier_id=?";
        return jdbcTemplate.update(sql,soldier.getSoldierName(),soldier.getSoldierWeapon(),soldier.getSoldierId());
    }
}
