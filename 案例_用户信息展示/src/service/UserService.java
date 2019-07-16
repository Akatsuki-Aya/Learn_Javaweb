package service;

import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

//用户管理的业务接口
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();
    public User login(User loginUser);

    /**
     * 添加User
     * @param user
     */
    void addUser(User user);

    /**
     * 根据id删除User
     * @param id
     */
    void deleteUser(String id);

    /**
     * 根据id查找User
     * @param id
     * @return
     */
    User findUserByid(String id);

    /**
     * 更新User
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除选中users
     * @param uids
     */
    void delSelectedUser(String[] uids);

    /**
     * 分页查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
