package web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
    /**
     * 在服务器关闭后, ServletContext对象被销毁. 当服务器正常关闭后该方法被调用
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象被销毁了...");
    }

    /**
     * 监听ServletContext对象创建的. ServletContext对象服务器启动后自动创建
     * 在服务器启动后自动调用
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //加载资源文件
        //1. 获取ServletContext对象
        ServletContext servletContext = sce.getServletContext();
        //2. 加载资源文件
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        //3. 获取真实路径
        String realPath = servletContext.getRealPath(contextConfigLocation);
        //4. 加载进内存

        try {
            FileInputStream fis = new FileInputStream(realPath);
            System.out.println(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ServletContext对象被创建了...");
    }
}
