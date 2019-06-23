package designMode.strategy;

/**
 * Created by chunchen.meng on 2019/6/21.
 */
/**
 * 3y(Context)
 */
public class Java3y {
    private IncreaseFansStrategy strategy ;

    public Java3y(IncreaseFansStrategy strategy) {
        this.strategy = strategy;
    }

    // 3y要发文章了(买水军了、送书了、写知乎引流了...)。
    // 具体执行哪个，看3y选哪个
    public void exec() {
        strategy.action();
    }
}
