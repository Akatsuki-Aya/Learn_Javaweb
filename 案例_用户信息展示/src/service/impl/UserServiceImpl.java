package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用dao完成查询
        return dao.findAll();
    }

    @Override
    public User login(User loginUser) {
        return dao.findUserByUsernameAndPasswd(loginUser.getUsername(),loginUser.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserByid(String id) {
        return dao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void delSelectedUser(String[] uids) {
        if (uids != null && uids.length>0) {
            for (String uid : uids) {
                dao.delete(Integer.parseInt(uid));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        //1. 创建空pagebean对象
        PageBean<User> pb = new PageBean<User>();
        //2. 设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //3. 调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //4. 调用dao查询list集合
        //5. 计算开始的记录索引
        int start = (currentPage-1) * rows;
        List<User> list = dao.findByPage(start,rows,condition);
        pb.setList(list);
        //6. 计算总页码
        int totalPage =
                (totalCount%rows == 0) ? (totalCount/rows) : ((totalCount/rows) +1);
        pb.setTotalPage(totalPage);
        return pb;
    }

}
