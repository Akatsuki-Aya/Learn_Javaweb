package test;

import Dao.UserDao;
import domain.User;
import org.junit.Test;


public class UserDaoTest {
    @Test
    public void LoginTest(){
        UserDao dao = new UserDao();
        User loginUser = new User();
        loginUser.setUsername("aya");
        loginUser.setPassword("123");
        User user = dao.Login(loginUser);
        System.out.println(user);
    }
}
