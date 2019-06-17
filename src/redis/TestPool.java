package redis;

/**
 * Created by chunchen.meng on 2019/5/31.
 * https://blog.csdn.net/hrlee520/article/details/82837591
 */
public class TestPool {
    public static void main(String[] args) {
        //初始化连接池
        RedisPoolUtil.initialPool();
        //启动1000个线程
        for (int i = 0; i < 100; i++) {
            ClientThread t = new ClientThread(i);
            t.start();
        }

        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
