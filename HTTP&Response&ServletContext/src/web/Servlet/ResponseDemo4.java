package web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ResponseDemo4")
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取流对象之前,去设置流的默认编码,ISO-8859-1 设置为GBK
        //response.setCharacterEncoding("utf-8");
        //告诉浏览器,服务器发送的消息体数据的编码. 建议浏览器使用该编码解码
        //response.setHeader("Content-type","text/html;charset=utf-8");
        //简单的形式来设置编码
        response.setContentType("text/html;charset=utf-8");
        //1.获取字节输出流
        ServletOutputStream sos = response.getOutputStream();
        //2.输出数据
        sos.write("你好, 世界".getBytes("utf-8"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
