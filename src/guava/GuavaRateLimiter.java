package guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * guava 限流工具
 * https://www.cnblogs.com/leeego-123/p/11492822.html
 */
public class GuavaRateLimiter {
    public static ConcurrentHashMap<String, RateLimiter> resourceRateLimiter = new ConcurrentHashMap<String, RateLimiter>();

    //初始化限流工具RateLimiter
    static {
        createResourceRateLimiter("order", 50);
    }

    public static void createResourceRateLimiter(String resource, double qps) {
        if (resourceRateLimiter.contains(resource)) {
            resourceRateLimiter.get(resource).setRate(qps);
        } else {
            //创建限流工具，每秒发出50个令牌指令
            RateLimiter rateLimiter = RateLimiter.create(qps);
            resourceRateLimiter.putIfAbsent(resource, rateLimiter);

        }

    }

    public static void main(String[] args) {
        Integer processors = Runtime.getRuntime().availableProcessors();
        System.out.println(processors);

        for (int i = 0; i < 500000000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //如果获得令牌指令tryAcquire，则执行业务逻辑
                    System.out.println(Thread.currentThread());
                    if (resourceRateLimiter.get("order").tryAcquire(10, TimeUnit.MICROSECONDS)) {
                        System.out.println("执行业务逻辑");
                    } else {
                        System.out.println("限流");
                    }
                }
            }).start();
        }

    }

}
