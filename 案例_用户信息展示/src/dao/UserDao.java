package dao;

import domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的DAO
 */
public interface UserDao {
    public List<User> findAll();
    public User findUserByUsernameAndPasswd(String username, String passwd);

    void add(User user);

    void delete(int id);

    User findUserById(int id);

    void update(User user);

    int findTotalCount(Map<String, String[]> condition);

    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
