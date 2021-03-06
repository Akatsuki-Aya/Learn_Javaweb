# Tomcat

## web服务器软件:

 * 服务器:安装了服务器软件的计算机

 * 服务器软件:接受用户的请求,处理请求,做出响应

 * web服务器软件:

   	* 在web软件中,可以部署web项目,让用户通过浏览器来访问这些项目
      	* web容器

 * 常见的Java相关的web服务器软件:

   	* webLogic:Oracle公司的,大型的javaEE服务器,支持所有的javaEE,收费的
      	* webSphere:IBM公司,大型的javaEE服务器,支持所有的javaEE,收费的
      	* Jboss:Jboss公司的,大型的javaEE服务器,支持所有的javaEE,收费的
              	* Tomcat:Apache基金组织,中小型,JavaEE服务器,仅仅支持少量的JavaEE规范Servlet/jsp.开源的,免费的.

 * JavaEE:Java语言在企业级开发中使用的技术规范的总和,一共规定了13项大的规范

 * Tomcat:web服务器软件

    * 下载

    * 安装

    * 卸载

    * 启动

    * 关闭

    * 配置

       * 部署项目的方式:

         1. 直接将项目放到webapps目录下即可

            * /hello: 项目的访问路径-->虚拟目录
            * 简化部署:将项目打成war包,再将war包放置到webapps目录下.
              * war包会自动解压缩

         2. 配置:conf/server.xml文件

            ​	在<Host>标签体中配置

            ​	<Context docBase="D:\hello" path="/hehe" />

            * docBase :项目存放的路径
            * path:虚拟目录

         3. 在conf\Catania\localhost创建任意名称的xml文件.在文件中去编写

            `<Context docBase="D:\hello" />`

            * 虚拟目录就是文件的名称

      * 静态项目和动态项目
      
        * 目录结构
      
          * java动态项目的目录结构:
      
            ​	-- 项目的根目录
      
            ​		-- WEB-INF目录
      
            ​			-- web.xml: web项目的核心配置文件
      
            ​			-- classes目录:放置字节码文件的目录
      
            ​			-- lib目录:放置依赖jar包
          
          * 将tomcat集成到idea中,并且创建javaEE的项目,部署项目

# Servlet入门学习:server applet

  * 概念: 运行在服务器端的小程序
    		* servlet就是一个接口,定义了Java类被浏览器访问到(tomcat识别)的规则
        		* 将来自定义一个类,实现servlet接口,复写方法

* 快速入门:

  1. 创建JavaEE的项目

  2. 定义一个类,实现Servlet接口

  3. 实现接口中的抽象方法

  4. 配置Servlet

     ​	在web.xml中配置

     ​	```

     ```xml
     <!-- 配置servlet -->
     <servlet>
         <servlet-name>demo</servlet-name>
         <servlet-class>web.Servlet.ServletDemo1</servlet-class>
     </servlet>
     <servlet-mapping>
         <servlet-name>demo</servlet-name>
         <url-pattern>/demo1</url-pattern>
     </servlet-mapping>
     ```

     ​	```

* 执行原理:

  1. 当前服务器接受到客户端浏览器的请求后,会解析请求的url路径,获取访问的servlet的资源路径
  2. 查找web.xml文件,是否有对应的<url-pattern>标签体内容
  3. 如果有,则在找到对应的<servlet-class>全类名
  4. tomcat会将字节码文件加载进内存,创建其对象
  5. 调用其方法

* servlet中的生命周期:

  1. 被创建:执行Init方法,只执行一次

     * servlet什么时候被创建

       * 默认情况下,第一次被访问时,servlet被创建

       * 可以配置执行servlet的创建时机.

         * 在<servlet>标签下配置

         * ```
           1.第一次被访问时,创建
           	* <load-on-startup>的值为负数,则第一次访问被创建
           2.在服务器启动时,创建
           	* <load-on-startup>的值为0或正整数
           ```

     * servlet的Init方法,只执行一次,说明一个servlet在内存中只存在一个对象,servlet是单例的
       * 多个用户同时访问时,可能存在线程安全问题
       * 解决:尽量不要在servlet中定义成员变量.即使定义了成员变量,也不要修改值

  2. 提供服务:执行service方法,执行多次

     * 每次访问servlet时,service方法都会被调用一次

  3. 被销毁:执行destroy方法,只执行一次

     * servlet被销毁时执行,服务器关闭时,servlet被销毁
     * 只有服务器正常关闭时,才会执行destroy方法
     * destroy方法在servlet被销毁之前执行,一般用于释放资源

* servlet 3.0:

  * 好处:
    * 支持注解配置.可以不需要web.xml
  * 步骤:
    1. 创建JavaEE项目,选择servlet版本3.0以上,可以不创建web.xml
    2. 定义一个类,实现servlet接口
    3. 复写方法
    4. 在类上使用@webServlet注解,进行配置
       * `@WebServlet("资源路径")`

* idea与tomcat的相关配置

  1. idea会为每一个tomcat部署的项目单独简历一份配置文件
  2. 工作空间 和 tomcat部署的web项目
     * tomcat真正访问的是"tomcat的部署项目","tomcat的部署项目"对应着"工作空间项目"的web目录下的所有资源
     * WEB-INF 目录下的资源不能被浏览器直接访问
  3. 断点调试:使用小虫子启动(Debug启动)

* servlet的体系结构

      	Servlet -- 接口

     ​		   |

     ​	GenericServlet  --  抽象类

     ​			|

     ​	HttpServlet  -- 抽象类

     * GenericServlet:将Servlet接口中其他的方法做了默认空实现,只将Service()作为抽象
          * 将来定义Servlet类时,可以继承GenericServlet,实现Service()方法即可
     * HttpServlet:对http协议的一种封装,简化操作
          1. 定义类继承HttpServlet
          2. 复写DoGet/DoPost方法

* Servlet相关配置

     1. urlpartten:Servlet访问路径
        1. 一个Servlet可以定义多个访问路径:`@WebServlet({"/d4","/dd4","/demo4"})`
        2. 路径定义规则:
           1. /xxx
           2. /xxx/xxx:多层路径,多层目录
           3. *.do



## HTTP:

 * 概念:Hyper Text Transfer Protocol 超文本传输协议

   	* 传输协议:定义了客户端和服务器端通信时,发送数据的格式
    * 特点:
      1. 基于TCP/IP的高级协议
      2. 默认端口号:80
      3. 基于请求响应模型的 一次请求对应一次响应
      4. 无状态的:每次请求之间相互独立,不能交互数据
   * 历史版本:
     * 1.0:每一次请求响应都会建立新的连接
     * 1.1:复用连接

* 请求消息数据格式

  * 请求行

    ​	请求方式  请求url  请求协议/版本

    ​	Get /Login.html  HTTP/1.1

     * 请求方式:
        * HTTP协议有7种请求方式,常用的有两种
           * GET:
             1. 请求参数在请求行中,在url后
             2. 请求的url长度是有限制的
             3. 不太安全
           * POST:
             1. 请求参数在请求体重
             2. 请求的url长度是无限制的
             3. 相对安全

  * 请求头:客户端浏览器告诉服务器一些信息

    ​	请求头名称:请求头值

    * 常见请求头:
      1. User-Agent:浏览器告诉服务器,我访问你使用的浏览器版本信息
         * 可以在服务器端获取该头的信息,解决浏览器的兼容性问题
      2. Referer:
         * 告诉服务器,我(当前请求)从哪里来?
           * 作用:
             1. 防盗链:
             2. 统计工作:

  * 请求空行

    ​	空行,就是用于分割POST请求的请求头和请求体的

  * 请求体(正文)

    * 封装POST请求消息的请求参数的

  * 字符串格式:

    ```html-request
    POST  /Login.html  HTTP/1.1
    Host: localhost
    User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36
    Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3
    Accept-Language: zh-CN,zh;q=0.9,ja;q=0.8
    Accept-Encoding: gzip, deflate, br
    Connection: keep-alive
    Upgrade-Insecure-Requests: 1
    
    username=zhangsan
    ```

* 响应消息数据格式



## Request

 1. request对象和response对象的原理

     	1. request和response对象是由服务器创建的.我们来使用它们
          	2. request对象是来获取请求消息,response对象来设置响应消息

 2. request对象继承体系结构:

    ​	ServletRequest -- 接口

    ​				|  继承

    ​	HTTPServletRequest  --  接口

    ​				|  实现

    ​	org.apache.catalina.connector.RequestFacade

 3. request 功能:

     	1. 获取请求消息数据
          	1. 获取请求行数据
              * GET /day14/demo1?name=zhangsan HTTP/1.1
              * 方法:
                1. 获取请求方式:GET
                   * `String getMethod()`
                2. (*)获取虚拟目录:/day14
                   * `String getContextPath()`
                3. 获取servlet路径:/demo1
                   * `String getServletPath()`
                4. 获取GET方式请求参数:name=zhangsan
                   * `String getQueryString()`
                5. (*)获取请求URI:/day14/demo1
                   * `String getRequestURI()`:/day14/demo1
                   * `StringBuffer getRequestURL()`:http://localhost/day14/demo1
                   * URL:统一资源定位符:http://localhost/day14/demo1  中华人民共和国
                   * URI:统一资源标识符:/day14/demo1  	                     共和国
                6. 获取协议版本:HTTP/1.1
                   * `String getProtocol()`
                7. 获取客户机的ip地址:
                   * `String getRemoteAddr()`
              	2. 获取请求头数据
              * 方法:
                * (*)`String getHeader(String name)`:通过请求头的名称获取请求头的值
                * `Enumeration<String> getHeaderNames()`:获取所有的请求头名称
              	3. 获取请求体数据
              * 请求体:只有POST请求方式,才有请求体,在请求体中封装了POST请求的请求参数
              * 步骤:
                1. 获取流对象:
                   1. `BufferedReader getReader()`: 获取字符输入流,只能操作字符数据
                   2. `ServletInputStream getInputStream()`:获取字节输入流,可以操作所有类型的数据
                      * 在文件上传知识点后讲解
                2. 再从流对象中拿数据:
          	2. 其他功能:
                  1. 获取请求参数通用方式
                        1. `String getParameter(String name)`:根据参数名称获取参数值 username=zhangsan&passwd=123
                        2. `String[] getParameterValues(String name)`:根据参数名称获取参数值的数组  hobby=xx&hobby=game
                        3. `Enumeration<String> getParameterNames()`: 获取所有请求的参数名称
                        4. `Map<String,String[]>getParameterMap()`:获取所有参数的集合 
                          * 中文乱码问题:
                            * get方式:tomcat 8 已经将get方式乱码问题解决了
                            * post方式: 会乱码
                              * 解决:在获取参数前,设置request的编码`request.setCharacterEncoding("utf-8");`
                  2. 请求转发:一种在服务器内部的资源跳转方式
                       1. 步骤:
                            1. 通过request对象获取请求转发器对象:`RequestDispatcher getRequestDispatcher(String path)`
                            2. 使用RequestDispatcher对象来进行转发: `forward(ServletRequest request, ServletResponse response)`
                       2. 特点:
                            1. 浏览器地址栏路径不发生变化
                            2. 只能转发到当前服务器内部资源中.
                            3. 转发是一次请求
                  3. 共享数据
                     * 域对象:一个有作用范围的对象,可以在范围内共享数据
                     * request域:代表一次请求的范围,一般用于请求转发的多个资源中共享数据
                     * 方法:
                       1. `setAttribute(String name,Object obj)`:存储数据
                       2. `Object getAttribute(String name)`:通过键获取值
                       3. `void removeAttribute(String name)`:通过键移除键值对
                       4. 
                  4. 获取ServletContext