package jedis.test;

import jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * jedis的测试类
 */
public class JedisTest {
    /**
     * 快速入门
     */
    @Test
    public void test1(){
        //1. 获取连接
        Jedis jedis = new Jedis("localhost",6379);
        //2. 操作
        jedis.set("username", "zhangsan");
        //3. 关闭连接
        jedis.close();
    }

    /**
     * string 数据结构操作
     */
    @Test
    public void test2(){
        //1. 获取连接
        Jedis jedis = new Jedis();//如果使用空参构造, 默认值是localhost:6379
        //2. 操作
        //存储
        jedis.set("username", "zhangsan");
        //获取
        String username = jedis.get("username");


        //可以使用setex()方法存储可以指定过期时间的 key value
        jedis.setex("activecode", 20, "hehe");//将activecode: "hehe" 键值对存入redis, 并且20s后自动删除键值对


        System.out.println(username);
        //3. 关闭连接
        jedis.close();
    }
    @Test
    public void test3(){
        //1. 获取连接
        Jedis jedis = new Jedis();
        //2. 操作
        jedis.hset("user","name","lisi");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","male");
        String name = jedis.hget("user", "name");
        System.out.println(name);
        //获取hash的所有map中的数据
        Map<String, String> user = jedis.hgetAll("user");
        //遍历集合
        //keyset
        Set<String> keySet = user.keySet();
        for (String key : keySet) {
            //获取value
            String value = user.get(key);
            System.out.println(key + " : " + value);
        }
        //3. 关闭连接
        jedis.close();
    }
    @Test
    public void test4(){
        //1. 获取连接
        Jedis jedis = new Jedis();
        jedis.del("mylist");
        //2. list操作
        jedis.lpush("mylist", "a", "b","c");
        jedis.rpush("mylist","a","b","c");
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);
        String lpop = jedis.lpop("mylist");
        System.out.println(lpop);
        String rpop = jedis.rpop("mylist");
        System.out.println(rpop);
        //3. 关闭连接
        jedis.close();
    }
    @Test
    public void test5(){
        //1. 获取连接
        Jedis jedis = new Jedis("localhost",6379);
        //2. 操作
        jedis.sadd("myset", "java", "c++", "python");
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);
        //3. 关闭连接
        jedis.close();
    }

    /**
     * jedis连接池使用
     */
    @Test
    public void test6(){
        //创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        //创建jedis连接池对象
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);
        //获取连接
        Jedis jedis = jedisPool.getResource();
        //使用
        jedis.set("hehe", "heihei");
        //关闭 归还到连接池中
        jedis.close();
    }
    @Test
    public void test7(){
        //通过连接池工具类获取
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("hello", "world");
        jedis.close();
    }
}
