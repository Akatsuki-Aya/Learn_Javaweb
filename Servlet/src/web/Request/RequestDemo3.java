package web.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/RequestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示获取请求头数据:user-agent
        String value = request.getHeader("user-agent");
        //判断agent的浏览器版本
        if(value.contains("Chrome")){
            System.out.println("谷歌来了...");
        }else if (value.contains("Firefox")){
            System.out.println("火狐来了...");
        }else{
            System.out.println("IE来了...");
        }
        //System.out.println(value);

    }
}
