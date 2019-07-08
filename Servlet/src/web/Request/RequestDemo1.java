package web.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示Request对象获取请求行数据
 */
@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1. 获取请求方式:GET
         *    - `String getMethod()`
         * 2. (*)获取虚拟目录:/day14
         *    - `String getContextPath()`
         * 3. 获取servlet路径:/demo1
         *    - `String getServletPath()`
         * 4. 获取GET方式请求参数:name=zhangsan
         *    - `String getQueryString()`
         * 5. (*)获取请求URI:/day14/demo1
         *    - `String getRequestURI()`:/day14/demo1
         *    - `StringBuffer getRequestURL()`:http://localhost/day14/demo1
         * 6. 获取协议版本:HTTP/1.1
         *    - `String getProtocol()`
         * 7. 获取客户机的ip地址:
         *    - `String getRemoteAddr()`
         */
        String method = request.getMethod();
        System.out.println(method);
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        String queryString = request.getQueryString();
        System.out.println(queryString);
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);
        String protocol = request.getProtocol();
        System.out.println(protocol);
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
