package web.ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //servletContext对象获取
        ServletContext servletContext1 = request.getServletContext();
        ServletContext servletContext2 = this.getServletContext();
        if(servletContext1 == servletContext2){
            System.out.println("yes");
            System.out.println(servletContext1);
        }else {
            System.out.println("no");
            System.out.println(servletContext1);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
