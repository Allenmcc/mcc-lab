package redis;

import java.util.Properties;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by chunchen.meng on 2019/5/31.
 */
public class RedisPoolUtil {
    private static JedisPool jedisPool = null;
    private static String redisConfigFile = "redis.properties";
    //把redis连接对象放到本地线程中
    private static ThreadLocal<Jedis> local=new ThreadLocal<Jedis>();

    //不允许通过new创建该类的实例
    private RedisPoolUtil() {
    }

    /**
     * 初始化Redis连接池
     */
    public static void initialPool() {
        try {
            Properties props = new Properties();
            //加载连接池配置文件
//            props.load(RedisPoolUtil.class.getClassLoader().getResourceAsStream(redisConfigFile));
            // 创建jedis池配置实例
            JedisPoolConfig config = new JedisPoolConfig();
            // 设置池配置项值
            //jedis的最大活跃连接数
            config.setMaxTotal(100);
            //jedis最大空闲连接数
            config.setMaxIdle(20);
            config.setMinIdle(8);
            config.setMaxWaitMillis(10000);
            config.setTestOnBorrow(true);
            config.setTestOnReturn(true);
            // 根据配置实例化jedis池
            jedisPool = new JedisPool(config, "127.0.0.1",
                    6379,
                    3000);
//                    "test123");
            System.out.println("线程池被成功初始化");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得连接
     * @return Jedis
     */
    public static Jedis getConn() {
        //Redis对象
        Jedis jedis =local.get();
        if(jedis==null){
            if (jedisPool == null) {
                initialPool();
            }
            jedis = jedisPool.getResource();
            local.set(jedis);
        }
        return jedis;
    }

    //新版本用close归还连接
    public static void closeConn(){
        //从本地线程中获取
        Jedis jedis =local.get();
        if(jedis!=null){
            jedis.close();
        }
        local.set(null);
    }

    //关闭池
    public static void closePool(){
        if(jedisPool!=null){
            jedisPool.close();
        }
    }
}
