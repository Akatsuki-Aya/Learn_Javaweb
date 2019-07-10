package web.ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/ServletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //servletContext对象功能
        ServletContext context = this.getServletContext();
        //获取文件的服务器路径
        String realPath = context.getRealPath("/b.txt");//web目录下资源访问
        System.out.println(realPath);
        //File file = new File(realPath);
        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源
        System.out.println(c);
        String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
        System.out.println(a);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
