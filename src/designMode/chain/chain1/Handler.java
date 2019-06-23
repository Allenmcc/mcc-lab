package designMode.chain.chain1;

/**
 * Created by chunchen.meng on 2019/6/20.
 */
public abstract class Handler {
    private Handler successor;

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    //对外暴露的方法
    public void execute() {
        handleProcess();
        if (successor != null) {
            successor.execute();
        }
    }

    // 需要子类实现
    protected abstract void handleProcess();
}
