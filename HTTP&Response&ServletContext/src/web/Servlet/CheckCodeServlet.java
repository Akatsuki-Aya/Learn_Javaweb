package web.Servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html;charset=utf-8");
        int width=100;
        int height = 50;
        //1. 创建一个对象, 在内存图片(验证码图片对象)
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //2. 美化图片
        //2.1 填充背景色
        Graphics g = image.getGraphics();//画笔对象
        g.setColor(Color.pink);
        g.fillRect(0,0,width,height);
        //2.2 画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);

        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //生成随机角标
        Random ran = new Random();
        for (int i = 0; i < 4; i++) {
            int index = ran.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index);

            //2.3 写验证码
            g.drawString(ch+"",width/5*(i+1),height/2);
        }
        //2.4 画干扰线
        g.setColor(Color.GREEN);
        for (int i = 0; i < 10; i++) {
            g.drawLine(ran.nextInt(width),ran.nextInt(height),ran.nextInt(width),ran.nextInt(height));
        }



        //3. 将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
