package cn.sit.aya.dao.Impl;

import cn.sit.aya.dao.ItemsDao;
import cn.sit.aya.domain.Items;
import cn.sit.aya.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ItemsDaoImpl implements ItemsDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Items> findAll() {
        String sql = "select * from items ; ";
        List<Items> items = template.query(sql, new BeanPropertyRowMapper<Items>(Items.class));
        return items;
    }
}
