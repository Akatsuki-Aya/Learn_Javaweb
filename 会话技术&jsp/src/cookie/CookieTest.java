package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * 1. 有: 不是第一次访问
 *    1. 响应数据: 欢迎回来, 您上一次访问时间为: 2019年7月11日20:45:10
 *    2. 写回cookie: lastTime = 2019年7月11日20:46:16
 * 2. 没有: 是第一次访问
 *    1. 响应数据: 您好, 欢迎您首次访问
 *    2. 写回cookie: lastTime = 2019年7月11日20:45:10
 */
@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag=false;
        if (cookies != null){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)){
                    flag=true;
                    String value = cookie.getValue();
                    value = URLDecoder.decode(value,"utf-8");
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    cookie.setValue(str_date);
                    cookie.setMaxAge(60*60*24*30);//1M
                    response.addCookie(cookie);
                    response.getWriter().write(
                            "<h1>欢迎回来, 您上次访问的时间为: " + value + "</h1>");
                    break;
                }
            }

        }
        if (cookies == null || cookies.length == 0 || flag==false){
            //没有
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            str_date = URLEncoder.encode(str_date, "utf-8");
            response.getWriter().write(
                    "<h1>您好, 欢迎您首次访问</h1>");
            Cookie cookie = new Cookie("lastTime",str_date);
            cookie.setMaxAge(60*60*24*30);//1M
            response.addCookie(cookie);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
