package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class JacksonTest {

    //Java对象转JSON字符串
    @Test
    public void test1() throws Exception {
        //1. 创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        //2. 创建Jackson的核心对象, ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3. 转换
        /**
         * 转换方法
         *      writeValue(参数1, obj):
         *          参数1:
         *              File: 将obj对象转换为JSON字符串, 并保存到指定的文件中
         *              Write: 将obj对象转换为JSON字符串, 并将JSON数据填充到字符输出流中
         *              OutputStream: 将obj对象转换为JSON字符串, 并将JSON数据填充到字节输出流中
         *      writeValueAsString(obj): 将对象转为JSON字符串
         */
        String json = mapper.writeValueAsString(p);
        //{"name":"张三","age":23,"gender":"男"}
        //System.out.println(json);
        //writeValue, 将数据写到d://a.txt文件中
        //mapper.writeValue(new File("E:\\新建文件夹\\JavaWeb\\AJAX&JSON\\a.txt"),p);
        //writeValue, 将数据关联到Writer中
        mapper.writeValue(new FileWriter("E:\\新建文件夹\\JavaWeb\\AJAX&JSON\\b.txt"),p);

    }
    @Test
    public void Test2() throws Exception {
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());
        //2. 转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        System.out.println(json);//{"name":"张三","age":23,"gender":"男","birthday":1563701222700}

    }
    @Test
    public void Test3() throws Exception {
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(23);
        p1.setGender("男");
        p1.setBirthday(new Date());
        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(23);
        p2.setGender("男");
        p2.setBirthday(new Date());
        //创建List集合
        List<Person> ps = new ArrayList<Person>();
        ps.add(p);
        ps.add(p1);
        ps.add(p2);

        //2. 转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ps);
        /**
         * [
         * {"name":"张三","age":23,"gender":"男","birthday":"2019-07-21"},
         * {"name":"张三","age":23,"gender":"男","birthday":"2019-07-21"},
         * {"name":"张三","age":23,"gender":"男","birthday":"2019-07-21"}
         * ]
         */
        System.out.println(json);

    }
    @Test
    public void Test4() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "张三");
        map.put("age", 23);
        map.put("gender", "男");
        //2. 转换
        ObjectMapper mapper = new ObjectMapper();
        //{"gender":"男","name":"张三","age":23}
        String json = mapper.writeValueAsString(map);
        System.out.println(json);

    }
    @Test
    public void Test5() throws Exception {
        //演示json字符串转Java对象
        //1. 初始化json字符串
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";
        //2. 创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        //3. 转换为Java对象 Person对象
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);

    }
}
