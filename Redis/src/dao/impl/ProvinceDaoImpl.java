package dao.impl;

import dao.ProvinceDao;
import domain.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
    //声明成员变量 JdbcTemplate
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Province> findAll() {
        String sql ="select * from province ; ";
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }

}
