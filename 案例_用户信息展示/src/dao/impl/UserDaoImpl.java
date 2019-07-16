package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库
        //1. 定义sql
        String sql = "select * from users";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findUserByUsernameAndPasswd(String username, String passwd) {
        try {
            String sql = "select * from users where username = ? and password = ? ;";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    username, passwd);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(User user) {
        //1. 定义sql
        String sql = "insert into users values(null,?,?,?,?,?,?,null,null);";
        //2. 执行sql
        template.update(sql,
                user.getName(),user.getGender(),user.getAge(),
                user.getAddress(),user.getQq(),user.getEmail());

    }

    @Override
    public void delete(int id) {
        String sql = "delete from users where id = ? ;";
        template.update(sql,id);
    }

    @Override
    public User findUserById(int id) {
        try {
            String sql = "select * from users where id = ? ;";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    id);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(User user) {
        String sql ="update users SET age=?, address=?, qq=?, email=? WHERE id = ?; ";
        template.update(sql,
                user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
        return;
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from users where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        //定义一个参数的集合
        List<Object> list = new ArrayList<Object>();
        for (String key : keySet) {
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if (value != null && !"".equals(value.trim())){
                sb.append(" and "+ key +" like ? ");
                list.add("%"+value.trim()+"%");//?条件的值
            }
        }
        System.out.println(sb.toString());
        System.out.println(list);
        return template.queryForObject(sb.toString(),Integer.class,list.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from users where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        //定义一个参数的集合
        List<Object> list = new ArrayList<Object>();
        for (String key : keySet) {
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if (value != null && !"".equals(value.trim())){
                sb.append(" and "+ key +" like ? ");
                list.add("%"+value.trim()+"%");//?条件的值
            }
        }
        sb.append(" limit ?,? ;");
        list.add(start);
        list.add(rows);
        sql = sb.toString();

        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),
                list.toArray());
    }
}
