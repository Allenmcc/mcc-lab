package queue;

/**
 * Created by chunchen.meng on 2019/5/5.
 */
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UserTask {
    //队列大小
    private final int QUEUE_LENGTH = 10000*10;
    //基于内存的阻塞队列
    private BlockingQueue<String> queue = new LinkedBlockingQueue<String>(QUEUE_LENGTH);
    //创建计划任务执行器
    private ScheduledExecutorService es = Executors.newScheduledThreadPool(1);

    /**
     * 构造函数，执行execute方法
     */
    public UserTask() {
        execute();
    }

    /**
     * 添加信息至队列中
     * @param content
     */
    public void addQueue(String content) {
        queue.add(content);
    }

    /**
     * 初始化执行
     */
    public void execute() {
        //每一分钟执行一次
        es.scheduleWithFixedDelay(new Runnable(){
            @Override
            public void run() {
                try {
                    String content = queue.take();
//                    String content = queue.peek();
                    //处理队列中的信息。。。。。

                    System.out.println(content);
//                    queue.poll();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, 0, 1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        UserTask userTask = new UserTask();
        userTask.addQueue("1");
        userTask.addQueue("2");
        userTask.addQueue("3");
        userTask.addQueue("4");

    }
}
