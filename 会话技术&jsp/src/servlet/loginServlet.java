package servlet;

import Dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 设置request编码
        request.setCharacterEncoding("utf-8");
        User loginUser = new User();
        //2. 获取参数map
        Map<String, String[]> parameterMap = request.getParameterMap();
        String checkCode = request.getParameter("checkCode");
        try {
            BeanUtils.populate(loginUser,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3. 先获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        session.removeAttribute("checkCode_session");
        //3. 先判断验证码是否正确
        if(checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)){//忽略大小写比较验证码
            //一致
            UserDao userDao= new UserDao();
            User user = userDao.login(loginUser);
            if ( user != null){
                //需要调用userdao查询数据库
                //登录成功
                //存储信息, 用户信息
                session.setAttribute("user",user);
                //重定向到success.jsp
                response.sendRedirect(request.getContextPath()+"/success.jsp");

            }else {
                //登录失败
                request.setAttribute("login_error","用户名或密码错误");
                // 转发到登录页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else {
            //不一致
            //存储提示信息到request
            request.setAttribute("cc_error","验证码错误");
            // 转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
