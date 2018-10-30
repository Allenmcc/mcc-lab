package timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by chunchen.meng on 2018/9/24.
 */
public class MyTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("任务执行了，时间为：" + new Date());
    }
}
